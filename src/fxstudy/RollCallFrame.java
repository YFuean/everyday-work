package fxstudy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Calendar;

public class RollCallFrame extends JFrame implements ActionListener {
    private OutputStream os;
    private BufferedReader bfr;
    private BufferedInputStream bfrPic;
    private JPanel SouthPanel,WestPanel,CenterPanel;
    private JMenuBar cd;
    private JMenu file;
    private JMenuItem leadIn,pictureIn;
    private JButton an1,an2;
    private JTextArea wby,wby1;
    private JTextField wbk;
    private JScrollPane gdt;
    private String line = null;
    private JLabel label;
    private ImageIcon image;
    private int i=-1,j=0;
    private boolean canExecute;

    public RollCallFrame(){
        //设置主窗体
        init();
        setTitle("点名小程序");
        setSize(1100,800);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private void init(){//init方法，主要写窗体
        file=new JMenu("文件");//创建“文件”菜单
        leadIn=new JMenuItem("名单");//创建“名单”菜单项
        leadIn.addActionListener(this);//给菜单项添加监听事件
        leadIn.setActionCommand("名单");//设置事件命令为“名单”
        pictureIn=new JMenuItem("图片");
        pictureIn.addActionListener(this);
        pictureIn.setActionCommand("图片");
        cd=new JMenuBar();//创建菜单栏
        file.add(leadIn);//“名单”菜单项 加入 “文件”菜单
        cd.add(file);//“文件”菜单 加入 菜单栏
        this.add(cd,BorderLayout.NORTH);//窗体设为边界布局，菜单栏放在北部

        an1=new JButton("缺席");//创建“缺席”按钮
        an1.addActionListener(this);//添加监听事件
        an1.setActionCommand("缺席");//设置事件命令
        an1.setSize(50,50);

        an2=new JButton("下一个");//创建“下一个”按钮
        an2.addActionListener(this);
        an2.setActionCommand("下一个");
        an2.setSize(50,50);

        SouthPanel=new JPanel();//创建“SouthPanel”面板
        SouthPanel.add(an1);//将两个按钮加入面板
        SouthPanel.add(an2);
        this.add(SouthPanel,BorderLayout.SOUTH);//窗体为边界布局，SouthPanel放在南部

        wby1=new JTextArea(20,12);//创建“wby1”文本域，20行，12列
        wby1.setFont(new Font("微软雅黑",Font.BOLD, 20));//设置文本域中 字体，粗细，大小
        gdt=new JScrollPane(wby1);//创建“gdt”滚动面板，加入文本域中
        WestPanel=new JPanel();//创建“WestPanel”面板
        WestPanel.add(gdt);//将“gdt”滚动面板放入“WestPanel”面板
        this.add(WestPanel,BorderLayout.WEST);//窗体为边界布局，WestPanel放在西部

        wby=new JTextArea(1,2);//创建“wby”文本域，1行2列
        wby.setFont(new Font("微软雅黑", Font.BOLD, 30));
        label=new JLabel();//创建标签
        CenterPanel=new JPanel();//创建CenterPanel面板
        CenterPanel.add(wby);//文本域放入CenterPanel
        CenterPanel.setBackground(Color.white);//设置背景颜色
        this.add(CenterPanel,BorderLayout.CENTER);//窗体为边界布局，CenterPanel放在中部
    }

    @Override
    public void actionPerformed(ActionEvent e) {//actionPerformed方法，主要写按钮的监听事件方法
        //左侧显示全班名单
        if(e.getActionCommand().equals("名单")){//如果事件命令等于“名单”
            try{// try/catch抓取IO异常
                bfr = new BufferedReader(new FileReader("D:/名单.md"));//new FileReader创建匿名 字符输入流，再放入“bfr”缓冲字符输入流
                wby1.setText("班级名单");
                wby1.setFont(new Font("微软雅黑", Font.BOLD, 28));
                wby1.setEditable(false);//设置文本域不可编辑
                while((line=bfr.readLine())!=null){//将bfr读入的Line赋值给字符串line,只要line不为空，执行以下操作
                    wby1.setText(wby1.getText()+'\n'+line);// '\n'换行
                }
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }else if(e.getActionCommand().equals("图片")){
            try {
                bfrPic = new BufferedInputStream(new FileInputStream("D:/"));


            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }else if(e.getActionCommand().equals("缺席")){//如果事件命令等于“缺席”
            if(canExecute==true){
                //将缺席名单导入D盘。调用getTimeByCalendar()方法命名文件。
                File file=new File("D:/"+ getTimeByCalendar()+"缺席名单.txt");
                if(!file.exists()){
                    try {
                        file.createNewFile();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
                try {
                    //使用字符输出流和缓冲字符输出流
                    BufferedWriter bfw=new BufferedWriter(new FileWriter(file,true));
                    bfw.write(wby.getText());
                    bfw.newLine();
                    bfw.flush();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }finally{
                    canExecute=false;
                }
            }
        }else if(e.getActionCommand().equals("下一个")){//如果事件命令等于“下一个”
            canExecute=true;
            if(!wby1.getText().equals("")){//播放姓名标签
                j=i+1;
                try {
                    bfr = new BufferedReader(new FileReader("D:/名单.md"));
                    for(i=0;i<j;i++){
                        bfr.readLine();
                    }
                    String str=bfr.readLine();
                    if(str!=null){
                        wby.setText(str);
                        addJLabel(str);
                    }else{
                        wby.setText("名单到此结束，请继续您需要的操作");
                        CenterPanel.remove(label);
                        SouthPanel.remove(an1);
                        SouthPanel.remove(an2);
                    }
                }catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }
    //日历函数
    public String getTimeByCalendar(){
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);//获取年份
        int month=cal.get(Calendar.MONTH);//获取月份
        int day=cal.get(Calendar.DATE);//获取日
        int WeekOfYear = cal.get(Calendar.DAY_OF_WEEK);//一周的第几天
        String time=year+"-"+(month+1)+"-"+day + "  星期" +(WeekOfYear-1 ) + "  " ;
        return time;
    }

    public void addJLabel(String name){
        String url=name+".png";
        label.setIcon(new ImageIcon(url));
        label.setSize(580,430);
        label.setLocation(200,80);
        label.setBackground(Color.white);
        CenterPanel.add(label);
    }

    public static void main(String[] args) {
        new RollCallFrame();
    }
}
