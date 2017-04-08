import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

public class MyPainter extends JFrame {
	private JButton line = new JButton("line");
	private JButton circle = new JButton("circle");
	private JButton square = new JButton("square");
	private JPanel buttonPanel = new JPanel();
	private Container c;
	private int shape,flag;
	private int  x1,y1,x2,y2;
    private ArrayList p = new ArrayList<Point>();
	public MyPainter(){
		super("»­°å");
		c=getContentPane();
		c.setLayout(new BorderLayout());
		c.add(buttonPanel,BorderLayout.WEST);
		buttonPanel.setLayout(new FlowLayout());
		buttonPanel.add(line);
		buttonPanel.add(circle);
		buttonPanel.add(square);
		line.addActionListener(new lineListener());
		circle.addActionListener(new circleListener());
		square.addActionListener(new squareListener());
		addMouseListener(new DrawListener());
		setSize(640,480);
		setVisible(true);
	}
	class lineListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			flag=1;
			shape=1;
		}
		
	}
	class circleListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			flag=1;
		    shape=2;
		}
		
	}
	class squareListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			flag=1;
			shape=3;
		}
		
	}
	class DrawListener extends MouseAdapter{
		public void mouseClicked(MouseEvent e){
			 Point p1 = new Point();
			 p1.shape=shape;
			if(flag==1){
				x1=e.getX();
			    y1=e.getY();
			    flag=2;
			}
			else if(flag==2){
				p1.x2=e.getX();
			    p1.y2=e.getY();
			    p1.x1=x1;
			    p1.y1=y1;
			    p.add(p1);
			    repaint();
			}
		}
	}
	public void paint(Graphics g){
		super.paint(g);
		if(flag==2){
			Point p2 = new Point();
			for(int i=0;i<p.size();i++) {
				p2= (Point) p.get(i);
				shape=p2.shape;
				x1=p2.x1;
				y1=p2.y1;
				x2=p2.x2;
				y2=p2.y2;
				System.out.println(i);
				switch(shape){
				case 1:g.drawLine( x1,y1,x2,y2);break;
				case 2:g.drawOval(x1,y1,Math.abs(x2-x1),Math.abs(x2-x1));break;
				case 3:g.drawRect(x1,y1,Math.abs(x2-x1),Math.abs(x2-x1));break;
				}
			}
			System.out.println(p.size());
			System.out.println("*************");
		}
		
		flag=1;
	}
	class Point{
		int shape,x1,y1,x2,y2;
	}
}
