package kucharka.gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Image;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.DefaultListSelectionModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;
import kucharka.api.CommentService;
import kucharka.api.IngredientService;
import kucharka.api.RecipeService;
import kucharka.gui.comments.CommentsPanel;
import kucharka.gui.dialogs.AddCommentDialog;
import kucharka.gui.dialogs.ViewCommentsDialog;
import kucharka.helpers.PrintUtilities;
import kucharka.impl.DBCommentServiceImpl;
import kucharka.impl.IngredientServiceImpl;
import kucharka.impl.RecipeServiceImpl;
import kucharka.model.Comment;
import kucharka.model.Recipe;

/**
 * Hlavni trida cele aplikace, reprezentuje hlavni JFrame
 * @author Jakub Josef
 */
public class KucharkaFrame extends javax.swing.JFrame {
    private RecipeService service = new RecipeServiceImpl();
    private RecipeTableModel tableModel = new RecipeTableModel();
    private IngredientService ingredientService=new IngredientServiceImpl();
    private CommentService commentService = new DBCommentServiceImpl();
    /* programove prepinace */
    private boolean expanded = false;
    private boolean orEnabled = false;
    private boolean noData = true;
    
    /* uloziste */
    private Recipe openedRecipe =null;
    private List<Recipe> data = null;

    public KucharkaFrame() {
        setResizable(false);
        initComponents();
        pnlRecipe.setVisible(false);
        tooglePnlRecipeActions(false);
        fitTableColumns();
        pack();
        getRootPane().setDefaultButton(btnSearch);
        initListeners();
        initIngredients();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jtfName = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        pnlResults = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbRecipes = new javax.swing.JTable();
        pnlIngredients = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        listIngredient = new javax.swing.JList();
        pnlMethod = new javax.swing.JPanel();
        jraAndOperator = new javax.swing.JRadioButton();
        jraOrOperator = new javax.swing.JRadioButton();
        pnlRecipeActions = new javax.swing.JPanel();
        btnSaveRecipe = new javax.swing.JButton();
        bntPrintRecipe = new javax.swing.JButton();
        pnlRecipe = new javax.swing.JPanel();
        lblName = new javax.swing.JLabel();
        lblImage = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        pnlRecipeIngredients = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        lstRecipeIngredients = new javax.swing.JList();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtProcess = new javax.swing.JTextArea();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        btnAddComment = new javax.swing.JButton();
        btnAllComments = new javax.swing.JButton();
        pnlComments = new kucharka.gui.comments.CommentsPanel();
        btnCloseRecipePane = new javax.swing.JButton();
        lblRating = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jtfName.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N

        btnSearch.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        btnSearch.setText("Hledat recept");
        btnSearch.setToolTipText("Hledat recept");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        tbRecipes.setModel(tableModel);
        tbRecipes.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_LAST_COLUMN);
        tbRecipes.setShowHorizontalLines(false);
        tbRecipes.setShowVerticalLines(false);
        jScrollPane1.setViewportView(tbRecipes);

        pnlIngredients.setBorder(javax.swing.BorderFactory.createTitledBorder("Vybrané suroviny"));

        listIngredient.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        listIngredient.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(listIngredient);

        javax.swing.GroupLayout pnlIngredientsLayout = new javax.swing.GroupLayout(pnlIngredients);
        pnlIngredients.setLayout(pnlIngredientsLayout);
        pnlIngredientsLayout.setHorizontalGroup(
            pnlIngredientsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlIngredientsLayout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pnlIngredientsLayout.setVerticalGroup(
            pnlIngredientsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlIngredientsLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pnlMethod.setBorder(javax.swing.BorderFactory.createTitledBorder("Metoda"));

        buttonGroup1.add(jraAndOperator);
        jraAndOperator.setSelected(true);
        jraAndOperator.setText("AND");
        jraAndOperator.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jraAndOperatorMouseClicked(evt);
            }
        });

        buttonGroup1.add(jraOrOperator);
        jraOrOperator.setText("OR");
        jraOrOperator.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jraOrOperatorMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnlMethodLayout = new javax.swing.GroupLayout(pnlMethod);
        pnlMethod.setLayout(pnlMethodLayout);
        pnlMethodLayout.setHorizontalGroup(
            pnlMethodLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMethodLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jraAndOperator)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jraOrOperator)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlMethodLayout.setVerticalGroup(
            pnlMethodLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMethodLayout.createSequentialGroup()
                .addGroup(pnlMethodLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jraAndOperator)
                    .addComponent(jraOrOperator))
                .addGap(0, 3, Short.MAX_VALUE))
        );

        pnlRecipeActions.setBorder(javax.swing.BorderFactory.createTitledBorder("Nástroje receptu"));

        btnSaveRecipe.setText("Uložit do souboru");
        btnSaveRecipe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveRecipeActionPerformed(evt);
            }
        });

        bntPrintRecipe.setText("Tisknout");
        bntPrintRecipe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bntPrintRecipeMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnlRecipeActionsLayout = new javax.swing.GroupLayout(pnlRecipeActions);
        pnlRecipeActions.setLayout(pnlRecipeActionsLayout);
        pnlRecipeActionsLayout.setHorizontalGroup(
            pnlRecipeActionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnSaveRecipe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(bntPrintRecipe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlRecipeActionsLayout.setVerticalGroup(
            pnlRecipeActionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRecipeActionsLayout.createSequentialGroup()
                .addComponent(btnSaveRecipe)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bntPrintRecipe)
                .addGap(0, 12, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlResultsLayout = new javax.swing.GroupLayout(pnlResults);
        pnlResults.setLayout(pnlResultsLayout);
        pnlResultsLayout.setHorizontalGroup(
            pnlResultsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlResultsLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnlResultsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlIngredients, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlRecipeActions, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlMethod, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(3, 3, 3))
        );
        pnlResultsLayout.setVerticalGroup(
            pnlResultsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlResultsLayout.createSequentialGroup()
                .addGroup(pnlResultsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(pnlResultsLayout.createSequentialGroup()
                        .addComponent(pnlIngredients, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnlMethod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(240, 240, 240)
                        .addComponent(pnlRecipeActions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        lblName.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        lblName.setText("nadpis_receptu");

        jLabel1.setText("Jak na to:");

        pnlRecipeIngredients.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Suroviny", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        lstRecipeIngredients.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        lstRecipeIngredients.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        lstRecipeIngredients.setFocusable(false);
        lstRecipeIngredients.setRequestFocusEnabled(false);
        jScrollPane4.setViewportView(lstRecipeIngredients);

        javax.swing.GroupLayout pnlRecipeIngredientsLayout = new javax.swing.GroupLayout(pnlRecipeIngredients);
        pnlRecipeIngredients.setLayout(pnlRecipeIngredientsLayout);
        pnlRecipeIngredientsLayout.setHorizontalGroup(
            pnlRecipeIngredientsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlRecipeIngredientsLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnlRecipeIngredientsLayout.setVerticalGroup(
            pnlRecipeIngredientsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)
        );

        txtProcess.setEditable(false);
        txtProcess.setColumns(20);
        txtProcess.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        txtProcess.setLineWrap(true);
        txtProcess.setRows(5);
        txtProcess.setWrapStyleWord(true);
        txtProcess.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane3.setViewportView(txtProcess);

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Komentáře", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        btnAddComment.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        btnAddComment.setText("Přidat komentář");
        btnAddComment.setFocusable(false);
        btnAddComment.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAddCommentMouseClicked(evt);
            }
        });

        btnAllComments.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        btnAllComments.setText("Všechny komentáře");
        btnAllComments.setFocusable(false);
        btnAllComments.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAllCommentsMouseClicked(evt);
            }
        });

        pnlComments.restrictItems(3);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(btnAllComments)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAddComment))
            .addComponent(pnlComments, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(pnlComments, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAllComments)
                    .addComponent(btnAddComment, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        btnCloseRecipePane.setIcon(new javax.swing.ImageIcon(getClass().getResource("/kucharka/res/img/close.png"))); // NOI18N
        btnCloseRecipePane.setToolTipText("Zavřít recept");
        btnCloseRecipePane.setBorderPainted(false);
        btnCloseRecipePane.setContentAreaFilled(false);
        btnCloseRecipePane.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCloseRecipePane.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCloseRecipePaneMouseClicked(evt);
            }
        });

        lblRating.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblRating.setForeground(java.awt.Color.red);
        lblRating.setText("rating");

        javax.swing.GroupLayout pnlRecipeLayout = new javax.swing.GroupLayout(pnlRecipe);
        pnlRecipe.setLayout(pnlRecipeLayout);
        pnlRecipeLayout.setHorizontalGroup(
            pnlRecipeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRecipeLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(pnlRecipeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlRecipeLayout.createSequentialGroup()
                        .addComponent(lblImage, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(pnlRecipeIngredients, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnlRecipeLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pnlRecipeLayout.createSequentialGroup()
                        .addComponent(lblName, javax.swing.GroupLayout.PREFERRED_SIZE, 490, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblRating)
                        .addGap(65, 65, 65)
                        .addComponent(btnCloseRecipePane, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3)))
            .addGroup(pnlRecipeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlRecipeLayout.createSequentialGroup()
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 702, Short.MAX_VALUE)))
        );
        pnlRecipeLayout.setVerticalGroup(
            pnlRecipeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRecipeLayout.createSequentialGroup()
                .addGroup(pnlRecipeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlRecipeLayout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(pnlRecipeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblName, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblRating)))
                    .addComponent(btnCloseRecipePane))
                .addGroup(pnlRecipeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlRecipeLayout.createSequentialGroup()
                        .addComponent(lblImage, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jLabel1))
                    .addComponent(pnlRecipeIngredients, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(17, 17, 17))
            .addGroup(pnlRecipeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 728, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Segoe Script", 0, 30)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Kuchařka ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jtfName, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pnlResults, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(15, 15, 15)
                .addComponent(pnlRecipe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlRecipe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jtfName, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(pnlResults, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void initIngredients() {
        listIngredient.removeAll();
        List<String> ingredients = ingredientService.loadIngredients();
        listIngredient.setListData(ingredients.toArray());
        listIngredient.setSelectionModel(new DefaultListSelectionModel(){


            @Override
            public void setSelectionInterval(int index0, int index1) {
                if (index0==index1) {
                    if (isSelectedIndex(index0)) {
                        removeSelectionInterval(index0, index0);
                        return;
                    }
                }
                super.setSelectionInterval(index0, index1);
            }

            @Override
            public void addSelectionInterval(int index0, int index1) {
                if (index0==index1) {
                    if (isSelectedIndex(index0)) {
                        removeSelectionInterval(index0, index0);
                        return;
                    }
                super.addSelectionInterval(index0, index1);
                }
            }

        });
    }
    /**
     * Vyhledavaci metoda vyvolana tlacitkem hledat nebo stisknutim entru
     * @param evt 
     */
    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        
        try {
             String searchQuery = jtfName.getText();
             List<String> indices = listIngredient.getSelectedValuesList();
             if(indices.isEmpty() && !searchQuery.isEmpty()){
                data = service.search(searchQuery);
             }else if(searchQuery.isEmpty() && !indices.isEmpty()){
                data = service.searchBySurovina(indices, orEnabled);
             }else{
                data = service.searchByNazevSurovina(searchQuery, indices, orEnabled);
             }
        } catch (Exception ex) {
            Logger.getLogger(KucharkaFrame.class.getName()).log(Level.SEVERE, "Chyba při vyhledávání receptu!", ex);
            JOptionPane.showMessageDialog(this, "Nepodařilo se připojit k serveru receptů!","Chyba",JOptionPane.ERROR_MESSAGE);
        }
        finally{
            if(!data.isEmpty()){
                tbRecipes.setModel(tableModel);
                tableModel.setData(data);
                fitTableColumns();
                noData=false;
            }else{
                tbRecipes.setModel(RecipeTableModel.getEmptyTableModel());
                tbRecipes.setTableHeader(null);
                noData=true;
            }
        }
        
    }//GEN-LAST:event_btnSearchActionPerformed

    private void jraOrOperatorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jraOrOperatorMouseClicked
        this.orEnabled=true;
    }//GEN-LAST:event_jraOrOperatorMouseClicked

    private void jraAndOperatorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jraAndOperatorMouseClicked
        this.orEnabled=false;
    }//GEN-LAST:event_jraAndOperatorMouseClicked

    private void btnCloseRecipePaneMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCloseRecipePaneMouseClicked
        toggleRecipePane();
        tooglePnlRecipeActions(false);
        this.expanded=false;
    }//GEN-LAST:event_btnCloseRecipePaneMouseClicked

    private void btnAddCommentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddCommentMouseClicked
        new AddCommentDialog(this, true).setRecipeID(this.openedRecipe).setVisible(true);
    }//GEN-LAST:event_btnAddCommentMouseClicked

    private void btnAllCommentsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAllCommentsMouseClicked
        new ViewCommentsDialog(this, true).setRecipeID(this.openedRecipe).setVisible(true);
    }//GEN-LAST:event_btnAllCommentsMouseClicked

    private void bntPrintRecipeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bntPrintRecipeMouseClicked
        btnCloseRecipePane.setVisible(false);
        PrintUtilities.printComponent(pnlRecipe);
        btnCloseRecipePane.setVisible(true);
    }//GEN-LAST:event_bntPrintRecipeMouseClicked

    private void btnSaveRecipeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveRecipeActionPerformed
        Recipe r = openedRecipe;
        
    }//GEN-LAST:event_btnSaveRecipeActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntPrintRecipe;
    private javax.swing.JButton btnAddComment;
    private javax.swing.JButton btnAllComments;
    private javax.swing.JButton btnCloseRecipePane;
    private javax.swing.JButton btnSaveRecipe;
    private javax.swing.JButton btnSearch;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JRadioButton jraAndOperator;
    private javax.swing.JRadioButton jraOrOperator;
    private javax.swing.JTextField jtfName;
    private javax.swing.JLabel lblImage;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblRating;
    private javax.swing.JList listIngredient;
    private javax.swing.JList lstRecipeIngredients;
    private kucharka.gui.comments.CommentsPanel pnlComments;
    private javax.swing.JPanel pnlIngredients;
    private javax.swing.JPanel pnlMethod;
    private javax.swing.JPanel pnlRecipe;
    private javax.swing.JPanel pnlRecipeActions;
    private javax.swing.JPanel pnlRecipeIngredients;
    private javax.swing.JPanel pnlResults;
    private javax.swing.JTable tbRecipes;
    private javax.swing.JTextArea txtProcess;
    // End of variables declaration//GEN-END:variables
    /**
     * Init metoda pro listenery
     */
    private void initListeners() {
        tbRecipes.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent e) {
                    if(tbRecipes.getSelectedRowCount()>0 && !noData){
                       Recipe r = data.get(tbRecipes.getSelectedRow());
                       if(!r.equals(openedRecipe)){
                          openRecipe(r);
                       }
                    }
                }
            });
    }
    /**
     * Metoda volana na jednotlivem receptu,
     * metoda otevre recept, nastavi ho a zobrazi okno s receptem
     * @param recipe 
     */
    private void openRecipe(Recipe recipe){
        if(!noData){
            if(!this.expanded){
                toggleRecipePane();
                this.expanded=true;
            }
            this.openedRecipe=recipe;
            fillPnlRecipe(recipe);
            tooglePnlRecipeActions(true);
        }
    }
    /**
     * Metoda naplni okno s receptem jednotlivymi polozkami,
     * je exkluzivne volana metodou openRecipe, aby došlo k nastavení aktuálně otevřeného receptu.
     * @param recipe 
     */
    private void fillPnlRecipe(Recipe recipe) {
        //labely
        lblName.setText(recipe.getName());
        txtProcess.setText(recipe.getProcess());
        txtProcess.setCaretPosition(0);
        //ingredience
        lstRecipeIngredients.setListData(recipe.getIngredience().toArray());
        //obrazek
        Image image;
        try {
            URL url = new URL(recipe.getObrazek());
            image = ImageIO.read(url);
            lblImage.setPreferredSize(new Dimension(image.getWidth(null), image.getHeight(null)));
            lblImage.setIcon(new ImageIcon(image));
        } catch (IOException e) {
            Logger.getLogger(KucharkaFrame.class.getName()).log(Level.WARNING,"Nepodarilo se nastavit obrazek i kdyz existuje",e);
        }
        //hodnoceni
        Float rating = commentService.getRating(recipe.getId());
        if(!rating.equals(new Float(0.0))){
            lblRating.setText(rating.toString());
        }else{
            lblRating.setText(null);
        }
        //komentare
        List<Comment> comments= commentService.getComments(recipe.getId());
        if(!comments.isEmpty()){
           pnlComments.setData(comments);
           btnAllComments.setEnabled(true);
        }else{
           pnlComments.setData(null);
           btnAllComments.setEnabled(false);
        }
        
                
        
    }

    public CommentsPanel getCommentsPane() {
        return pnlComments;
    }
    public JLabel getRatingPane(){
        return lblRating;
    }

    public JButton getAllCommentsButton(){
        return btnAllComments;
    }
    /**
     * Metoda zmeni stav (zavre nebo otevre) panel s receptem
     */
    private void toggleRecipePane() {
        pnlRecipe.setVisible(!expanded);
        this.pack();
    }
   /**
    * Metoda prepina zobrazeni panelu s operacemi nad jednotlivim receptem 
    * @param newState 
    */
    private void tooglePnlRecipeActions(boolean newState) {
        if(pnlRecipeActions.isEnabled() != newState){
            pnlRecipeActions.setEnabled(newState);
            Component[] com =pnlRecipeActions.getComponents();
            for (int i = 0; i < com.length; i++) {
                Component component = com[i];
                component.setEnabled(newState);
            }
        }
     }
    /**
     * Metoda upravi zobrazeni sloupcu tabulky s recepty
     */
    private void fitTableColumns() {
        DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer();
        headerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        
        TableColumn col1 = tbRecipes.getColumnModel().getColumn(0);
        TableColumn col2 = tbRecipes.getColumnModel().getColumn(1);
        col1.setCellRenderer(headerRenderer);
        col1.setHeaderRenderer(headerRenderer);
        col1.setMaxWidth(75);
        col2.setHeaderRenderer(headerRenderer);
        tbRecipes.getTableHeader().setBackground(Color.LIGHT_GRAY);
        
    }


}
