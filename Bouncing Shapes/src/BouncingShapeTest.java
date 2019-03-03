import javax.swing.JFrame;

public class BouncingShapeTest {
	public static void main(String[] args) {
		JFrame fr = new JFrame();
		BouncingShapes b = new BouncingShapes();
		fr.add(b);
		fr.setVisible(true);
		fr.setSize(600, 400);
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fr.setTitle("Bouncing Shapes");
	}
}
