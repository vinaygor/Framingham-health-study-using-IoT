/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Business.CalculateMen;
import Business.CalculateWomen;
import Business.VitalSign;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Rishabh
 */
public class Input extends javax.swing.JPanel {

    /**
     * Creates new form Input
     */
    JPanel userProcessContainer;
    public Input(JPanel userProcessContainer) {
        initComponents();
        this.userProcessContainer=userProcessContainer;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupGender = new javax.swing.ButtonGroup();
        buttonGroupSmoker = new javax.swing.ButtonGroup();
        buttonGroupDiabetes = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jRadioButtonMale = new javax.swing.JRadioButton();
        jRadioButtonFemale = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jRadioButtonDiabetesYes = new javax.swing.JRadioButton();
        jRadioButtonDiabetesNo = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        jRadioButtonSmokerYes = new javax.swing.JRadioButton();
        jRadioButtonSmokerNo = new javax.swing.JRadioButton();
        jLabel7 = new javax.swing.JLabel();
        txtAge = new javax.swing.JTextField();
        txtTotalChol = new javax.swing.JTextField();
        txtHdlChol = new javax.swing.JTextField();
        txtSystolic = new javax.swing.JTextField();
        btnSubmit = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Person Age:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Gender:");

        buttonGroupGender.add(jRadioButtonMale);
        jRadioButtonMale.setText("Male");

        buttonGroupGender.add(jRadioButtonFemale);
        jRadioButtonFemale.setText("Female");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("Total Cholestrol:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("HDL Cholestrol:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("Diabetes:");

        buttonGroupDiabetes.add(jRadioButtonDiabetesYes);
        jRadioButtonDiabetesYes.setText("Yes");

        buttonGroupDiabetes.add(jRadioButtonDiabetesNo);
        jRadioButtonDiabetesNo.setText("No");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setText("Smoker:");

        buttonGroupSmoker.add(jRadioButtonSmokerYes);
        jRadioButtonSmokerYes.setText("Yes");

        buttonGroupSmoker.add(jRadioButtonSmokerNo);
        jRadioButtonSmokerNo.setText("No");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setText("Systolic Blood Pressure:");

        btnSubmit.setText("Submit");
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(142, 142, 142)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7))
                        .addGap(36, 36, 36)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtAge)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jRadioButtonMale)
                                .addComponent(jRadioButtonDiabetesYes)
                                .addComponent(jRadioButtonSmokerYes))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jRadioButtonSmokerNo)
                                .addComponent(jRadioButtonFemale)
                                .addComponent(jRadioButtonDiabetesNo)))
                        .addComponent(txtTotalChol)
                        .addComponent(txtHdlChol)
                        .addComponent(txtSystolic))
                    .addComponent(btnSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(358, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButtonMale)
                    .addComponent(jRadioButtonFemale)
                    .addComponent(jLabel2))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jRadioButtonSmokerYes)
                            .addComponent(jRadioButtonSmokerNo)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtTotalChol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtHdlChol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jRadioButtonDiabetesYes)
                    .addComponent(jRadioButtonDiabetesNo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtSystolic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(btnSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(149, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
        VitalSign vitalSign=new VitalSign();
        int age=Integer.parseInt(txtAge.getText());
        String gender=null;
        if(jRadioButtonMale.isSelected()){
            gender="Male";
        }
        else if(jRadioButtonFemale.isSelected()){
            gender="Female";
        }
        else{
            JOptionPane.showMessageDialog(null,"Please Select Gender");
        }
        int totalChol=Integer.parseInt(txtTotalChol.getText());
        int hdlChol=Integer.parseInt(txtHdlChol.getText());
        boolean smoker=false;
        if(jRadioButtonSmokerYes.isSelected()){
            smoker=true;
        }
        else if(jRadioButtonSmokerNo.isSelected()){
            smoker=false;
        }
        else{
            JOptionPane.showMessageDialog(null,"Please Select Smoker option");
        }
        boolean diabetes=false;
        if(jRadioButtonDiabetesYes.isSelected()){
            diabetes=true;
        }
        else if(jRadioButtonDiabetesNo.isSelected()){
            diabetes=false;
        }
        else{
            JOptionPane.showMessageDialog(null,"Please Select Diabetes option");
        }
        int systolic=Integer.parseInt(txtSystolic.getText());
        
        vitalSign.setBloodPressure(systolic);
        vitalSign.setDiabetes(diabetes);
        vitalSign.setSmoker(smoker);
        vitalSign.setTotalCholestrol(totalChol);
        vitalSign.setHdlCholestrol(hdlChol);
        if(gender.equals("Male")){
            CalculateMen calculateMen=new CalculateMen();
         vitalSign=calculateMen.calculateRiskScore(vitalSign, age);
          
        }else{
            CalculateWomen calculateWomen=new CalculateWomen();
         vitalSign=calculateWomen.calculateRiskScore(vitalSign, age);
          
        }
        Result result=new Result(userProcessContainer,vitalSign);
        userProcessContainer.add("Result",result);
CardLayout layout=(CardLayout)userProcessContainer.getLayout();
layout.next(userProcessContainer);
// TODO add your handling code here:
    }//GEN-LAST:event_btnSubmitActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSubmit;
    private javax.swing.ButtonGroup buttonGroupDiabetes;
    private javax.swing.ButtonGroup buttonGroupGender;
    private javax.swing.ButtonGroup buttonGroupSmoker;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JRadioButton jRadioButtonDiabetesNo;
    private javax.swing.JRadioButton jRadioButtonDiabetesYes;
    private javax.swing.JRadioButton jRadioButtonFemale;
    private javax.swing.JRadioButton jRadioButtonMale;
    private javax.swing.JRadioButton jRadioButtonSmokerNo;
    private javax.swing.JRadioButton jRadioButtonSmokerYes;
    private javax.swing.JTextField txtAge;
    private javax.swing.JTextField txtHdlChol;
    private javax.swing.JTextField txtSystolic;
    private javax.swing.JTextField txtTotalChol;
    // End of variables declaration//GEN-END:variables
}
