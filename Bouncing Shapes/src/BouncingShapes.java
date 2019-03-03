import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.security.SecureRandom;

import javax.swing.*;

public class BouncingShapes extends JComponent implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Timer timer;
	private int x;
	private int y;
	private int velX, velY, velx1, vely1;
	private int x1, y1;
	private int dX, dY;

	Ellipse2D.Double c1;
	Ellipse2D.Double c2;

	SecureRandom random;

	public BouncingShapes() {
		random = new SecureRandom();
		timer = new Timer(3, this);
		x = 0;
		y = 0;
		x1 = 41 + random.nextInt(400);
		y1 = 41 + random.nextInt(400);
		velX = 3;
		velY = 7;
		velx1 = 4;
		vely1 = 3;
	}

	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.black);
		c1 = new Ellipse2D.Double(x, y, 40, 40);
		c2 = new Ellipse2D.Double(x1, y1, 40, 40);
		g2.fill(c1);
		g2.fill(c2);
		timer.start();
	}

	public boolean isTouched(Ellipse2D c1, Ellipse2D c2) {
		dX = (int) Math.abs(c1.getX() - c2.getX());
		dY = (int) Math.abs(c1.getY() - c2.getY());

		if (dX <= 40 && dY <= 40) {
			return true;
		} else
			return false;
	}

	public void actionPerformed(ActionEvent e) {
		dX = (int) Math.abs(c1.getX() - c2.getX());
		dY = (int) Math.abs(c1.getY() - c2.getY());

		/*
		 * Check if the borders of the frame are touched or ellipses touch each other In
		 * each case they will move in the opposite direction
		 */
		if (x < 0 || x > 560 || isTouched(c1, c2))
			velX = -velX;

		if (y < 0 || y > 360 || isTouched(c1, c2))
			velY = -velY;

		if (x1 < 0 || x1 > 560 || isTouched(c1, c2))
			velx1 = -velx1;

		if (y1 < 0 || y1 > 360 || isTouched(c1, c2))
			vely1 = -vely1;

		/*
		 * Add to each coordinate how much the movement will change in each axis.
		 */
		x += velX;
		y += velY;
		x1 += velx1;
		y1 += vely1;

		repaint();
	}
}
