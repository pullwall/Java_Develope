import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ChatCanvas extends JFrame {

    ToolPanel toolPanel;
    CanvasPanel canvasPanel;
    
    // 버튼들 구현
    JButton colorButtons[] = new JButton[8];    // 컬러 버튼. 추후 열거형으로 색을 지정하던지 해서 고유 번호 설정할 계획
    JButton figureButtons[] = new JButton[3];   // 도형 버튼. 선, 사각형, 원
    JButton toolButtons[] = new JButton[2];     // 도구 버튼. 펜, 지우개 정도 구현할 예정

    /* 통신 구현
     * private Socket   socket;
     * private PrintWriter writer;
     * private BufferedReader reader;
     */

    // Brush 좌표값
    int x, y;

    public static void main(String[] args) {
        new ChatCanvas();
    }
    // 생성자
    public ChatCanvas() {
        init();
        setting();
        batch();
        listener();
        setVisible(true);
    }

    
    // 초기화 메소드
    private void init() {
        toolPanel = new ToolPanel();
        canvasPanel = new CanvasPanel();
    }
    
    // 세팅 메소드
    private void setting() {
        setTitle("Canvas");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);                        // 창의 크기를 조절 못하게 하는 메소드       

        add(toolPanel, BorderLayout.NORTH);
        add(canvasPanel, BorderLayout.CENTER);
        pack();
        setJMenuBar(createMenu());
        setSize(500, 500);
    }

    // 일괄 처리 메소드
    private void batch() {

    }

    // 이벤트 리스너 메소드
    private void listener() {

    }
    // 캔버스 생성 메소드

    // 메뉴판 생성 메소드
    private static JMenuBar createMenu() {
        JMenuBar mb = new JMenuBar();
        JMenu fileMenu = new JMenu("File");

        fileMenu.add(new JMenuItem("Load"));
        fileMenu.add(new JMenuItem("Save"));
        fileMenu.addSeparator();
        fileMenu.add(new JMenuItem("Exit"));

        mb.add(fileMenu);

        return mb;
    }
}

class ToolPanel extends JPanel {
    public ToolPanel () {
        setBackground(Color.LIGHT_GRAY);
        setLayout(getLayout());
        

        Color colors[] = {  Color.BLACK, Color.WHITE, Color.RED, Color.ORANGE, Color.YELLOW,
                            Color.GREEN, Color.BLUE, Color.MAGENTA};
        // 컬러 버튼 생성 및 색 지정. 검흰 빨주노초파-보
        for(int i = 0; i < colorButtons.length; i++) {
            colorButtons[i] = new JButton();
            colorButtons[i].setBackground(colors[i]);
            colorButtons[i].setSize(5, 5);
            add(colorButtons[i]);
        }
    }
}

class CanvasPanel extends JPanel implements ActionListener, MouseListener, MouseMotionListener{
    private Point firstPointer = new Point(0,0);
    private Point secondPointer = new Point(0,0);
    private Color color = Color.black;
    private int width;
    private int height;
    private int minPointx;
    private int minPointy;

    public CanvasPanel() {
        setBackground(Color.WHITE);

    }

    public void mousePressed(MouseEvent e) {
        firstPointer.setLocation(0, 0);
        secondPointer.setLocation(0, 0);

        firstPointer.setLocation(e.getX(), e.getY());
    }



    @Override
   public void mouseMoved(MouseEvent e) {}
   @Override
   public void mouseClicked(MouseEvent e) {}
   @Override
   public void mouseEntered(MouseEvent e) {}
   @Override
   public void mouseExited(MouseEvent e) {}
}
