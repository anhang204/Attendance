/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package forms;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import dao.ConnectionProvider;
import java.sql.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.HeadlessException;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.Temporal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import utility.BDUtility;

/**
 *
 * @author 5530
 */
public class MarkAttendance extends javax.swing.JFrame implements Runnable, ThreadFactory {

    private WebcamPanel panel = null;
    private Webcam webcam = null;
    private ExecutorService executor = Executors.newSingleThreadExecutor(this);
    private volatile boolean running = true;
    public MarkAttendance() {
        initComponents();
        BDUtility.setImage(this, "images/abc1.jpg", 1438, 768);
        this.getRootPane().setBorder(BorderFactory.createMatteBorder(4,4,4,4, Color.BLACK));
        initWedcam();
        
        Timer timer = new Timer(1, e->updateTime());
        timer.start();
    }
    
    private void updateTime(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
        lblTime.setText(simpleDateFormat.format(new Date()));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnExit = new javax.swing.JButton();
        webCamPanel = new javax.swing.JPanel();
        lblImage = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblTime = new javax.swing.JLabel();
        lblCheckInCheckOut = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1366, 768));
        setUndecorated(true);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Mark Attendance");

        btnExit.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnExit.setText("x");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        webCamPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Date");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Time");

        lblTime.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lblTime.setText("Time");

        lblCheckInCheckOut.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        lblName.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(598, 598, 598)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 634, Short.MAX_VALUE)
                .addComponent(btnExit)
                .addGap(17, 17, 17))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(webCamPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(199, 199, 199)
                        .addComponent(lblCheckInCheckOut, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(lblTime, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(98, 98, 98)
                                        .addComponent(jLabel4)
                                        .addGap(82, 82, 82)))
                                .addGap(75, 75, 75))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(lblImage, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(42, 42, 42))))))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(894, Short.MAX_VALUE)
                    .addComponent(lblName, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(302, 302, 302)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnExit)
                    .addComponent(jLabel1))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(webCamPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(38, 38, 38)
                        .addComponent(lblTime, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(lblImage, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(71, 71, 71)
                        .addComponent(lblCheckInCheckOut, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(135, 135, 135))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(554, Short.MAX_VALUE)
                    .addComponent(lblName, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(177, 177, 177)))
        );

        webCamPanel.getAccessibleContext().setAccessibleName("");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        running  = false;
        stopWebcam();
        
        if(executor != null && !executor.isShutdown()){
            executor.shutdown();
        }
        this.dispose();
    }//GEN-LAST:event_btnExitActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MarkAttendance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MarkAttendance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MarkAttendance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MarkAttendance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MarkAttendance().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel lblCheckInCheckOut;
    private javax.swing.JLabel lblImage;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblTime;
    private javax.swing.JPanel webCamPanel;
    // End of variables declaration//GEN-END:variables

    Map<String,String> resultMap = new HashMap<String, String>();
    @Override
    public void run() {
       do {
           try{
               Thread.sleep(1000);
           }catch (InterruptedException ex){
                   
            }
           
           try{
               Result result = null;
               BufferedImage image = null;
               if (webcam != null && webcam.isOpen()) {
                    image = webcam.getImage();
                }

               if (image == null) {
                   continue;
                }

               
               LuminanceSource source = new BufferedImageLuminanceSource(image);
               BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
               
               try{
                   result = new MultiFormatReader().decode(bitmap);
               }catch (NotFoundException ex){
                   
               }
               
               if(result != null){
                   String jsonString = result.getText();
                   Gson gson = new Gson();
                   java.lang.reflect.Type type = new TypeToken<Map<String,String>>(){                       
                   }.getType();
                   resultMap = gson.fromJson(jsonString, type);
                   
                   String finalPath = BDUtility.getPath("images\\" + resultMap.get("email") + ".jpg");
                   CircularImageFrame(finalPath);
               }
           }catch(Exception ex){
               ex.printStackTrace();
           }
       } while(true);
    }

    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r, "My Thread");
        t.setDaemon(true);
        return t;
    }

    private void initWedcam() {
        webcam = Webcam.getDefault();
        if(webcam != null){
            Dimension[] resolutions = webcam.getViewSizes();
            Dimension maxResolution = resolutions[resolutions.length-1];
            
            if(webcam.isOpen()){
                webcam.close();
            }
            
            webcam.setViewSize(maxResolution);
            webcam.open();
            
            panel = new WebcamPanel(webcam);
            panel.setPreferredSize(maxResolution);
            panel.setFPSDisplayed(true);
            
            webCamPanel.add(panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 689, 518));
            executor.execute(this);
            executor.shutdown();
        } else {
            System.out.println("Issue with webcam.");
        }
    }
    
    private void stopWebcam (){
        if(webcam != null && webcam.isOpen()){
            webcam.close();
        }
    }

    private BufferedImage imagee = null;
    private void CircularImageFrame(String imagePath) {
       try{
           Connection con = ConnectionProvider.getCon();
           Statement st = con.createStatement();
           ResultSet rs = st.executeQuery("select * from Employee where email='" + resultMap.get("email") + "';");
           if(!rs.next()){
               showPopUpForCertainDuration("Employee is not Registered or Deleted", " Invalid QR", JOptionPane.ERROR_MESSAGE);
               return;
           }
           
           imagee = null;
           File imageFile = new File(imagePath);
           if(imageFile.exists()){
               try{
                   imagee = ImageIO.read(new File(imagePath));
                   imagee = createCircularImage(imagee);
                   ImageIcon icon = new ImageIcon(imagee);
                   lblImage.setIcon(icon);
               }catch(Exception ex){
                   ex.printStackTrace();
               }
           }else{
               BufferedImage imageeee = new BufferedImage(300,300, BufferedImage.TYPE_INT_ARGB);
               Graphics2D g2d = imageeee.createGraphics();
               
               g2d.setColor(Color.BLACK);
               g2d.fillOval(25, 25, 250, 250);
               
               g2d.setFont(new Font("Serif", Font.BOLD, 250));
               g2d.setColor(Color.WHITE);
               g2d.drawString(String.valueOf(resultMap.get("name").charAt(0)).toUpperCase(), 75, 225);
               g2d.dispose();
               ImageIcon imageIconn = new ImageIcon(imageeee);
               lblImage.setIcon(imageIconn);
               this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               this.pack();
               this.setLocationRelativeTo(null);
               this.setVisible(true);
           }
           lblName.setHorizontalAlignment(JLabel.CENTER);
           lblName.setText(resultMap.get("name"));
           if(!checkInCheckOut()){
               return;
           }
       }catch (Exception ex){
           ex.printStackTrace();
       }
    }

    private void showPopUpForCertainDuration(String popUpMessage, String popUpHeader, Integer iconId)throws HeadlessException {
        final JOptionPane optionPane = new JOptionPane ( popUpMessage, iconId);
        final JDialog dialog = optionPane.createDialog(popUpHeader);
        Timer timer = new Timer(5000, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                dialog.dispose();
                clearUserDetails();
            }
        });
        timer.setRepeats(false);
        timer.start();
        dialog.setVisible(true);
    }
    private void clearUserDetails() {
                lblCheckInCheckOut.setText("");
                lblCheckInCheckOut.setBackground(null);
                lblCheckInCheckOut.setForeground(null);
                lblCheckInCheckOut.setOpaque(false);
                lblName.setText("");
                lblImage.setIcon(null);
            }

    private BufferedImage createCircularImage(BufferedImage imagee) {
        int diameter =285;
        BufferedImage resizedImage = new BufferedImage(diameter, diameter, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = resizedImage.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(imagee, 0,0, diameter, diameter, null);
        g2.dispose();
        BufferedImage circularImage = new BufferedImage(diameter, diameter, BufferedImage.TYPE_INT_ARGB);
        g2 = circularImage.createGraphics();
        Ellipse2D.Double circle = new Ellipse2D.Double(0, 0, diameter, diameter);
        g2.setClip(circle);
        g2.drawImage(resizedImage, 0, 0, null);
        g2.dispose();
        return circularImage;
    }

    private boolean checkInCheckOut() throws HeadlessException, SQLException{
       String popUpHeader = null;
       String popUpMessage = null;
       Color color = null;
       
       Connection con = ConnectionProvider.getCon();
       Statement st = con.createStatement();
       
       LocalDate currentDate = LocalDate.now();
       DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
       
       LocalDateTime currentDateTime = LocalDateTime.now();
       DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
       
       ResultSet rs = st.executeQuery("select * from Attendance where date ='"+currentDate.format(dateFormatter)+ "' and employeeID=" + Integer.valueOf(resultMap.get("id"))+ ";");
       Connection connection = ConnectionProvider.getCon();
       if(rs.next()){
           String checkOutDateTime = rs.getString(4);
           if(checkOutDateTime != null){
               popUpMessage = "Already CheckOut For the Day";
               popUpHeader = "Invalid CheckOut";
               showPopUpForCertainDuration(popUpMessage, popUpHeader, JOptionPane.ERROR_MESSAGE);
               return false;
           }
           String checkInDateTime = rs.getString(3);
           LocalDateTime checkInLocalDateTime = LocalDateTime.parse(checkInDateTime, dateTimeFormatter);
           Duration duration = Duration.between(checkInLocalDateTime, currentDateTime);
           
           long hours = duration.toHours();
           long minutes = duration.minusHours(hours).toMinutes();
           long seconds = duration.minusHours(hours).minusMinutes(minutes).getSeconds();
           
           if(!(hours > 0 ||(hours == 0&& minutes >= 3))){
               long remainingMinutes = 3 - minutes;
               long remainingSeconds = 60 - seconds;
               
               popUpMessage = String.format("Your work duration is less than 5 minutes\nYou can check out after: %d minutes and %d seconds", remainingMinutes, remainingSeconds);
               popUpHeader = "Duration Warning";
               
               showPopUpForCertainDuration(popUpMessage, popUpHeader, JOptionPane.WARNING_MESSAGE);
               return false;
           }
           
           String updateQuery = "update Attendance set checkout=?, workduration=? where date=? and employeeID=?";
           PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);
           preparedStatement.setString(1, currentDateTime.format(dateTimeFormatter));
           preparedStatement.setString(2, "" + hours + "Hours and" + minutes + " Minutes");
           preparedStatement.setString(3, currentDate.format(dateFormatter));
           preparedStatement.setString(4, resultMap.get("id"));
           
           preparedStatement.executeUpdate();
           popUpHeader = "CheckOut";
           popUpMessage = "Checked Out at" + currentDateTime.format(dateTimeFormatter) + "\nWork Duration "+ hours + "Hours and " + minutes + " Minutes";
           color = Color.red;
       } else{
           //CheckIn
           String insertQuery = "INSERT INTO Attendance (employeeID, date, checkin) VALUES (?,?,?)";
           PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
           preparedStatement.setString(1, resultMap.get("id"));
           preparedStatement.setString(2, currentDate.format(dateFormatter));
           preparedStatement.setString(3, currentDateTime.format(dateTimeFormatter));
           preparedStatement.executeUpdate();
           popUpHeader = "CheckIn";
           popUpMessage = "Check In at "+currentDateTime.format(dateTimeFormatter);
           color = Color.GREEN;
       }
       
       lblCheckInCheckOut.setHorizontalAlignment(JLabel.CENTER);
       lblCheckInCheckOut.setText(popUpHeader);
       lblCheckInCheckOut.setForeground(color);
       lblCheckInCheckOut.setBackground(Color.DARK_GRAY);
       lblCheckInCheckOut.setOpaque(true);
       showPopUpForCertainDuration(popUpMessage, popUpHeader, JOptionPane.INFORMATION_MESSAGE);
       return Boolean.TRUE;
    }
    @Override
    public void paint(Graphics g){
        super.paint(g);
        if(imagee!= null){
            g.drawImage(imagee, 0, 0, null);
        }
    }
}
