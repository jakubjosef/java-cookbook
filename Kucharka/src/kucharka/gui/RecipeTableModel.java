package kucharka.gui;

import java.util.List;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import kucharka.model.Recipe;

public class RecipeTableModel extends DefaultTableModel{
    private List<Recipe> data = null;
    private String[] tableLabels = {"Kategorie","Název"};
    private final int tableColumnsNum = 2;
    
    public void setData(List<Recipe> data){
        this.data=data;
        fireTableDataChanged();
     }

    @Override
    public String getColumnName(int column) {
         return tableLabels[column];
    }

    @Override
    public int getColumnCount() {
        return this.tableColumnsNum;
    }
   
    @Override
    public int getRowCount() {
        if(data!=null){
            return data.size();
        }else{
            return 0;
        }
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }

    @Override
    public Object getValueAt(int row, int column) {
        Recipe recipe = data.get(row); 
        switch(column){
            case 0 : return recipe.getCategory();
            case 1 : return recipe.getName();
            default: return null;
        }
        
    }
    /* prazdny table model */
    public static TableModel getEmptyTableModel(){
        return new EmptyTableModel();
    }
    private static class EmptyTableModel extends DefaultTableModel{
        
        @Override
        public int getColumnCount() {
            return 1;
        }

        @Override
        public int getRowCount() {
            return 1;
        }

        @Override
        public String getColumnName(int column) {
            return " ";
        }
        
        @Override
        public Object getValueAt(int row, int column) {
            return "Nenalezeny žádné recepty.";
        }
        
        
        
    
    }
    
    
    
    
}
