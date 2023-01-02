
 
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
//import java.awt.Font;

 
public class Notepad extends JFrame  {
    // 멤버변수
    public static JTextArea ita = new JTextArea(20,50);
    public static JTextArea ota = new JTextArea(20,50);
    public  JScrollPane upperPanel = new JScrollPane(ita); 
    public JScrollPane lowerPanel = new JScrollPane(ota);
    public static JButton btn =new JButton("정리");

    JFileChooser chooser = new JFileChooser();
    JMenuBar mb = new JMenuBar();
    // 생성자
    public Notepad() {
        
        this.setTitle("Ready To Deploy");
        this.setSize(500, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        // 2. 메뉴생성
        String[] smenu = { "파일" };
        JMenu[] mfile = new JMenu[10];
        for (int i = 0; i < smenu.length; i++) {
            mfile[i] = new JMenu(smenu[i]);
            mb.add(mfile[i]);
        }
 
 
        String[] ScrItem = { "새파일", "열기", "저장", "다른이름으로저장", "종료" };
        JMenuItem[] item = new JMenuItem[6];
        for (int i = 0; i < ScrItem.length; i++) {
            item[i] = new JMenuItem(ScrItem[i]);
            // 1. 이벤트 소스: JMenuItem
            // 4. 메뉴바 설정
            this.setJMenuBar(mb);
            mfile[0].add(item[i]);
 
        }
        upperPanel.setBackground(Color.gray);
        lowerPanel.setBackground(Color.pink);
        // 컴포넌트 추가
        this.add(upperPanel,"North");
        this.add(lowerPanel,"South");
        this.add(btn);

        this.pack();
        this.setVisible(true);
    }
    public static void main(String[] args) {
        new Notepad();

        btn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e ){
                String workSheet=ita.getText();
                Converter con = new Converter();
                String result =con.toText(workSheet);
                ota.setText(result);
            }
        });
    }
 
}
 
