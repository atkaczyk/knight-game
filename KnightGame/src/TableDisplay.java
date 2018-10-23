import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;

public class TableDisplay extends JFrame {
	private JPanel panel;

	private JTable table;
	private Controller control;

	private Thread bfsThread;

	public TableDisplay(){
		int rows = 20;
		int columns = 20;
		

		panel = new JPanel();
		panel.setLayout(new BorderLayout());

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		table = new JTable(rows, columns);
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				handleMouse(e);
			}
		});


		panel.add(table);
		add(panel, BorderLayout.CENTER);
		setSize(rows * 20, columns*20);
		control = new Controller(this);
		setVisible(true); 

	}
	
	public void endGame(){
		for (int i = 0; i < table.getRowCount(); i++){
			for(int j = 0; j < table.getColumnCount(); j++) {
				table.setValueAt("*", i, j);
			}
		}
		if(bfsThread!=null){
			bfsThread.stop();
		}
	}

	public  void update(BoardState board){
		clearTable(table);


		drawTable(board);

		for (int i = 0; i < board.getNumPawns(); i++){
			table.setValueAt("P", board.getPawnY(i),board.getPawnX(i));
		}
		
	}

	public  void clearTable( JTable table) {
		for (int i = 0; i < table.getRowCount(); i++)
			for(int j = 0; j < table.getColumnCount(); j++) {
				table.setValueAt("", i, j);
			}
	}
	public  void handleMouse(MouseEvent e){
		JTable target = (JTable)e.getSource();
		int trow = target.getSelectedRow();
		int tcol = target.getSelectedColumn();
		//use of threads to 
		
		control.checkValidMove(trow, tcol);
	}
	
	private void bfsStuff(){
		control.bfs();
		bfsThread = new Thread(new Runnable(){
			@Override
			public void run() {
				control.updateBFS();
				try {
					bfsThread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		bfsThread.start();
	}
	

	public  void drawTable(BoardState board){

		table.setValueAt("K", board.getKnightY(), board.getKnightX());

		table.setValueAt("O", board.getKnightY() + 2 , board.getKnightX() + 1);
		table.setValueAt("O", board.getKnightY() - 2 , board.getKnightX() + 1);
		table.setValueAt("O", board.getKnightY() + 2 , board.getKnightX() - 1);
		table.setValueAt("O", board.getKnightY() - 2 , board.getKnightX() - 1);

		table.setValueAt("O", board.getKnightY() + 1 , board.getKnightX() + 2);
		table.setValueAt("O", board.getKnightY() - 1 , board.getKnightX() + 2);
		table.setValueAt("O", board.getKnightY() + 1 , board.getKnightX() - 2);
		table.setValueAt("O", board.getKnightY() - 1 , board.getKnightX() - 2);
	}







}
