package fr.iutvalence.info.dut.m2107;

import java.awt.Color;
import java.awt.Component;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class Cell extends DefaultTableCellRenderer
{

	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column)
	{
		Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

		if (column == 0 || column==9 )
			cell.setBackground(Color.LIGHT_GRAY);
		else if (row % 2 == 0)
		{
			if (column % 2 == 0)
				cell.setBackground(Color.BLACK);
			if (column % 2 == 1)
				cell.setBackground(Color.WHITE);
		}
		else if (row % 2 == 1)
		{
			if (column % 2 == 0)
				cell.setBackground(Color.WHITE);
			if (column % 2 == 1)
				cell.setBackground(Color.BLACK);
		}
		//TODO
	   // ((JLabel) cell).setIcon(new ImageIcon("ressources/noir/cavalier.png"));

		return cell;
	}
}