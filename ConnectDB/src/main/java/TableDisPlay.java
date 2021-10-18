import java.sql.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.* ;
import java.util.*;

public class TableDisPlay extends JFrame  {
	private Connection con ;
	private JTable table ;
	JTextArea mText ; 
	JButton Exec ; 
	JButton Reset ;
	JPanel Pn ; 
	String mSQL ; 
	JLabel f  = new JLabel("Status : ");
	
	public TableDisPlay()	// constructor
	{
		super("Demo use Jtable with Database");
		Pn = new JPanel() ; 
		mText = new JTextArea("SELECT * FROM Employee",4,30);
		Exec = new JButton("Execute");
		Reset = new JButton("Reset");
		
		Reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
	        {
					 mText.setText("");
	
			}
			});						
		
		Exec.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
	        {
					 getTable();
			}
			});			
	
		Pn.setLayout(new BorderLayout());
		Pn.add(new JScrollPane(mText),BorderLayout.NORTH);
		Pn.add(Exec,BorderLayout.CENTER);
        Pn.add(Reset,BorderLayout.SOUTH);
		
		this.getContentPane().setLayout(new BorderLayout());
		this.getContentPane().add(Pn , BorderLayout.NORTH);
		this.getContentPane().add(f , BorderLayout.SOUTH);
		
		String url = "jdbc:odbc:Minh" ;
		try {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			con = DriverManager.getConnection(url,"sqlsa" , "sqlsa");
		}
		catch( ClassNotFoundException cnfex ) {
			JOptionPane.showMessageDialog(this,"Khong co Class nay" , "Error Meassage" , JOptionPane.ERROR_MESSAGE);
			System.exit(0);  }
		catch (SQLException qq ) {
			JOptionPane.showMessageDialog(this,"Cau lenh loi","Error Meassage" , JOptionPane.ERROR_MESSAGE);
			System.exit(0);  }
			
		getTable();
		setSize(500,500	);
		show();
	}
	
	private void getTable()
	{
		Statement stmt ; 
		ResultSet rs ;
		
		try {
			mSQL = mText.getText();
			stmt = con.createStatement();
			rs = stmt.executeQuery(mSQL);
			
			displayResultSet(rs);
			rs.close();
			stmt.close();
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(this,"Cau lenh loi","Error Meassage" , JOptionPane.ERROR_MESSAGE);
			  }
			
	}
	
		
	//-----------------------------------------------------------------------
	private void displayResultSet(ResultSet rs) throws SQLException
	{
		boolean moreRec = rs.next();
		if (!moreRec) {
			JOptionPane.showMessageDialog(this,"Khong co Record !!!");
			this.setTitle("No Records to Display");
			return ;
		}
				
		Vector columnHeaders = new Vector() ;
		Vector rows = new Vector();
		
		try {
			ResultSetMetaData rm = rs.getMetaData();
			for (int i = 1 ; i<=  rm.getColumnCount() ; i++ )
				columnHeaders.addElement(rm.getColumnName(i));
			do {
				rows.addElement(getNextRow(rs,rm));
			} while (rs.next());
			
			
			if (table!=null)
				this.getContentPane().remove(2);
			table = new JTable(rows,columnHeaders);
			JScrollPane sc = new JScrollPane(table);	
			this.getContentPane().add(sc,BorderLayout.CENTER);
			validate();
		
		}
		catch (SQLException e) {
				JOptionPane.showMessageDialog(this,"Du lieu loi !!!","Error Meassage", JOptionPane.ERROR_MESSAGE); }
		Vector A = (Vector)rows.elementAt(2);
		JOptionPane.showMessageDialog(null , A.elementAt(0));
	}
	//------------------------------------------------------------------
	public Vector getNextRow(ResultSet rs , ResultSetMetaData rm) throws SQLException
	{
		Vector current = new Vector();
		for (int i = 1 ; i<=  rm.getColumnCount() ; i++ )
	/*	 switch (rm.getColumnType(i))
		 {
		 	case Types.VARCHAR :
		 	case Types.CHAR :	
		 	case Types.OTHER :
		 		current.addElement(rs.getString(i)); break;
			case Types.INTEGER :
			case Types.SMALLINT :
			case Types.TINYINT :
				current.addElement(new Long(rs.getLong(i))); break;
			
		 }				*/
		 current.add(rs.getString(i));
		 return current;
	}
	//------------------------------------------------------------------
	public void shutdown()
	{
		try {
			con.close();
		} catch (SQLException e) {
				JOptionPane.showMessageDialog(this,"Khong dong ket noi duoc !!","Error Meassage" , JOptionPane.ERROR_MESSAGE); }
	}	
	
	//-----------------------------------------------------------------------
	public static void main(String av[])
	{
		final TableDisPlay A = new TableDisPlay();
		A.addWindowListener( new WindowAdapter() {
			public void windowClosing(WindowEvent e)
			{
				A.shutdown();
				System.exit(0);
			}	
		});	
	}
}			
				

