package docSpeed;

import java.io.IOException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jdesktop.application.Action;
import org.jdesktop.application.SingleFrameApplication;
import org.jdesktop.application.FrameView;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.apache.commons.net.tftp.TFTP;
import org.apache.commons.net.tftp.TFTPClient;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.Region;

/**
 * The application's main frame.
 */
public class DocSpeedView extends FrameView {

    public DocSpeedView(SingleFrameApplication app) {
        super(app);

        initComponents();
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(docSpeed.DocSpeedApp.class).getContext().getResourceMap(DocSpeedGetFileBox.class);
        app.getMainView().getFrame().setIconImage(new ImageIcon("mexIcon.jpg").getImage());
        log("DocSpeed v"+resourceMap.getString("Application.version")+" by "+resourceMap.getString("Application.vendor"));
        log("Ok ready when you are...");
    }

    @Action
    public void showAboutBox() {
        if (aboutBox == null) {
            JFrame mainFrame = DocSpeedApp.getApplication().getMainFrame();
            aboutBox = new DocSpeedAboutBox(mainFrame);
            aboutBox.setLocationRelativeTo(mainFrame);
        }
        DocSpeedApp.getApplication().show(aboutBox);
    }
    
    @Action
    public void showBrowser() throws IOException {
        JFrame mainFrame = DocSpeedApp.getApplication().getMainFrame();
        fileBox = new DocSpeedGetFileBox(mainFrame, true);
        fileBox.setLocationRelativeTo(mainFrame);
        TXTFileFilter filtro = new TXTFileFilter();
        JFileChooser jFileChooser1 = new javax.swing.JFileChooser();
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(docSpeed.DocSpeedApp.class).getContext().getResourceMap(DocSpeedGetFileBox.class);
        jFileChooser1.setAcceptAllFileFilterUsed(false);
        jFileChooser1.setApproveButtonText(resourceMap.getString("jFileChooser1.approveButtonText")); // NOI18N
        jFileChooser1.setCurrentDirectory(new java.io.File("c:\\"));
        jFileChooser1.setDialogTitle(resourceMap.getString("jFileChooser1.dialogTitle")); // NOI18N
        jFileChooser1.setFileFilter(filtro);
        jFileChooser1.setName("jFileChooser1"); // NOI18N
        int pathBox = jFileChooser1.showDialog(fileBox, "Select TXT");
        if(pathBox == JFileChooser.APPROVE_OPTION){
            File archivo = jFileChooser1.getSelectedFile();
            String path = archivo.getCanonicalFile().toString();
            jTextField1.setText(path);
            fileBox.dispose();
        }
    }
    
 
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton2 = new javax.swing.JButton();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        javax.swing.JMenu fileMenu = new javax.swing.JMenu();
        javax.swing.JMenuItem exitMenuItem = new javax.swing.JMenuItem();
        javax.swing.JMenu helpMenu = new javax.swing.JMenu();
        javax.swing.JMenuItem aboutMenuItem = new javax.swing.JMenuItem();

        mainPanel.setName("mainPanel"); // NOI18N

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(docSpeed.DocSpeedApp.class).getContext().getResourceMap(DocSpeedView.class);
        jLabel1.setText(resourceMap.getString("jLabel1.text")); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N

        jTextField1.setEditable(false);
        jTextField1.setText(resourceMap.getString("jTextField1.text")); // NOI18N
        jTextField1.setName("jTextField1"); // NOI18N

        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance(docSpeed.DocSpeedApp.class).getContext().getActionMap(DocSpeedView.class, this);
        jButton1.setAction(actionMap.get("showBrowser")); // NOI18N
        jButton1.setText(resourceMap.getString("jButton1.text")); // NOI18N
        jButton1.setName("jButton1"); // NOI18N

        jLabel2.setText(resourceMap.getString("jLabel2.text")); // NOI18N
        jLabel2.setName("jLabel2"); // NOI18N

        jLabel3.setText(resourceMap.getString("jLabel3.text")); // NOI18N
        jLabel3.setName("jLabel3"); // NOI18N

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        jTextArea1.setBackground(resourceMap.getColor("jTextArea1.background")); // NOI18N
        jTextArea1.setColumns(20);
        jTextArea1.setFont(resourceMap.getFont("jTextArea1.font")); // NOI18N
        jTextArea1.setForeground(resourceMap.getColor("jTextArea1.foreground")); // NOI18N
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jTextArea1.setWrapStyleWord(true);
        jTextArea1.setName("jTextArea1"); // NOI18N
        jScrollPane1.setViewportView(jTextArea1);

        jButton2.setAction(actionMap.get("startScan")); // NOI18N
        jButton2.setText(resourceMap.getString("jButton2.text")); // NOI18N
        jButton2.setName("jButton2"); // NOI18N

        jTextField2.setText(resourceMap.getString("jTextField2.text")); // NOI18N
        jTextField2.setName("jTextField2"); // NOI18N

        jTextField3.setEditable(false);
        jTextField3.setText(resourceMap.getString("msgTxt.text")); // NOI18N
        jTextField3.setName("msgTxt"); // NOI18N

        jLabel4.setText(resourceMap.getString("jLabel4.text")); // NOI18N
        jLabel4.setName("jLabel4"); // NOI18N

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 557, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 458, Short.MAX_VALUE)
                                    .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 458, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextField2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(288, 288, 288)))
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3))
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 357, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(7, 7, 7))
        );

        menuBar.setName("menuBar"); // NOI18N

        fileMenu.setText(resourceMap.getString("fileMenu.text")); // NOI18N
        fileMenu.setName("fileMenu"); // NOI18N

        exitMenuItem.setAction(actionMap.get("quit")); // NOI18N
        exitMenuItem.setName("exitMenuItem"); // NOI18N
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);

        helpMenu.setText(resourceMap.getString("helpMenu.text")); // NOI18N
        helpMenu.setName("helpMenu"); // NOI18N

        aboutMenuItem.setAction(actionMap.get("showAboutBox")); // NOI18N
        aboutMenuItem.setName("aboutMenuItem"); // NOI18N
        helpMenu.add(aboutMenuItem);

        menuBar.add(helpMenu);

        setComponent(mainPanel);
        setMenuBar(menuBar);
    }// </editor-fold>//GEN-END:initComponents

    @Action
    public void startScan() throws FileNotFoundException, IOException {
        textFile = jTextField1.getText();
        tftpIp = jTextField2.getText();
        if(!textFile.equals("")){
            if(!tftpIp.equals("")){
                log("Reading CM Config Names content from " + textFile);
                log("Starting to download & Analyze Config CM Files...");
                log("Please note if your TXT file is HUGE, this will take");
                log("a bit more time... but this works great just as it is");
                log("so please just sit down & relax :)");
                jTextArea1.setText("");
                jTextField2.setEnabled(false);
                jButton1.setEnabled(false);
                jButton2.setEnabled(false);
                log("\nGetting configs from text file...");
                 new Thread(new ReadWithScanner(textFile,tftpIp)).start();
            } else {
                jTextArea1.setText("Hey buddie, enter your TFTP Server IP!!");
            }
        }else{
            jTextArea1.setText("Ehem... Aren't you forgetting something?\nWhere's the config file list!??");
        }
    }
    private String textFile;
    private String tftpIp;
    
    private void log(Object aObject) {
        jTextArea1.append(String.valueOf(aObject) + "\n");
        jTextArea1.setCaretPosition(jTextArea1.getDocument().getLength());
    }
    
    private void statusMsg(String msg){
        jTextField3.setText(msg);
    }
    
    class ReadWithScanner implements Runnable{
        private final File fFile;
        private String name;
        private String lastName ="";
        private String resultFile;
        private Boolean bolAppend;
        private List<String> configList = new ArrayList<String>();
        private List<String> downloaded = new ArrayList<String>();;
        private List<String> failed = new ArrayList<String>();;
        private List<String> failedDecode = new ArrayList<String>();;
        private List<String> decoded = new ArrayList<String>();;
        private HSSFWorkbook wb = new HSSFWorkbook();
        private HSSFSheet sheet = wb.createSheet("CMDownloader v0.5 Results File");
        private HSSFFont font = wb.createFont();
        private int rowNum = 3;
        private int index = 0;
        
        public ReadWithScanner(String aFileName, String ip){
            fFile = new File(aFileName);
            name = "";
            bolAppend = false;
            resultFile = "";
        }
        
        public void run() {
            try {
                processLineByLine();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(DocSpeedView.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(DocSpeedView.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        public final void processLineByLine() throws FileNotFoundException, IOException {
            try {
                Scanner scanner = new Scanner(fFile);
                while(scanner.hasNextLine()){
                    String cm = scanner.nextLine();
                    configList.add(cm);
                    //getFileData(cm);
                    index++;
                }
                scanner.close();
            }
            catch(FileNotFoundException ex){
                log(ex);
            }
            catch(IOException ex){
                log(ex);
            }
            finally {
                log("Scan finished, identified "+index+" config file names.");
                log("Doownloading config files...");
                statusMsg("Downloading "+index+" Config Files... Please Wait...");
                String[] al = new String[configList.size()];
                al = configList.toArray(al);
                getFiles(al);
            }
        }
        
        public final void getFiles(String[] configs) throws IOException{
            List<String> result = new ArrayList<String>();
            int i = 0;
            int largo = configs.length;
            
            for(i=0;i<configs.length;i++){
                result.add(getFilefromTFTP(configs[i], tftpIp,i,largo));
            }

            for(i=0;i<result.size();i++){
                if(!result.get(i).equals("Failure")){
                    downloaded.add(result.get(i));
                } else {
                    failed.add(result.get(i));
                }
            }
            
            log("Finished with downloads now decoding "+downloaded.size()+" config files...");
            getFilesData();
        }
        
        public String getFilefromTFTP(String CMFile, String ip,int tot, int length){
            try{
                TFTPClient client = new TFTPClient();
                client.open();
                FileOutputStream cmOut = new FileOutputStream("temp\\"+CMFile);
                client.receiveFile(CMFile,TFTP.BINARY_MODE, cmOut, ip);
                cmOut.close();
                client.close();
                statusMsg("Downloaded "+tot+" of "+ length +" Files...");
                return CMFile;
            }catch(Exception exc){
                log(CMFile +" failed while downloading... moving to the next file");
                return "Failure";
            }
        }
        
        public final void getFilesData() throws IOException{
            List<String> tempRes = new ArrayList<String>();
            int i=0;
            int x=0;
            try{
            for(i=0;i<downloaded.size();i++){
                statusMsg("Decoded "+(i+1)+" of "+ downloaded.size() +" Files...");
                tempRes.add(getFileData(downloaded.get(i)));
            }

            for(x=0;x<tempRes.size();x++){
                for(i=0;i<downloaded.size();i++){
                    if(tempRes.get(x).equals(downloaded.get(i))){
                        if(decoded.indexOf(downloaded.get(i))==-1){
                            decoded.add(downloaded.get(i));
                        }
                    }
                }
                if(tempRes.get(x).equals("F")){
                    failedDecode.add(downloaded.get(i));
                }
            }
            
            log("Decoded "+decoded.size() +" files successfully!");
            if(failedDecode.size()>0){
                log(failedDecode.size() +" files failed on decoding.");
            }
            finishProcess();
            }catch(Exception e){
                log("Error: " + e.getLocalizedMessage());
            }
        }
        
        public String getFileData(String CMFile){
            try {
                name = CMFile;
                String filePath = "temp\\" + CMFile;
                Process p = Runtime.getRuntime().exec("bin\\docsis\\docsis.exe -d " + filePath);
                BufferedReader inputStream = new BufferedReader(new InputStreamReader(p.getInputStream()));
                PrintWriter outputStream   = new PrintWriter(new FileWriter("temp\\"+CMFile+".txt"));
                
                String inLine = null;

                while ((inLine = inputStream.readLine()) != null) {
                    outputStream.println(inLine);
                }
                
                inputStream.close();
                outputStream.close();
                
                //BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));
                /*int i = 0;
                Scanner scan = new Scanner(stdInput);
                while(scan.hasNextLine()){
                    String s = scan.nextLine().trim().toString();
                    int rate = s.indexOf("MaxRateSustained");
                    if(rate!=-1){
                        //writeFileData(s,1);
                    } else {
                        int rate2 = s.indexOf("MaxRateDown");
                        if(rate2!=-1){
                            //writeFileData(s,2);
                        } else {
                            int rate3 = s.indexOf("MaxRateUp");
                            if(rate3!=-1){
                                //writeFileData(s,3);
                            }
                        }
                    }
                }*/
                //scan.close();
                return CMFile;
            }catch (Exception e) {
                log("fallo " + CMFile);
                return "F";
            }
        }
        
        public void writeFileData(String line, int type) throws IOException, ParseException{        
            String[] texts;

            line = line.replace(";","");
            line = line.trim();
            
            if(type==1){
                texts = line.split("MaxRateSustained");
            } else if(type==2){
                texts = line.split("MaxRateDown");
            } else {
                texts = line.split("MaxRateUp");
            }
            String dato = texts[1].trim();
            
            if(!dato.equals("0")){
                Integer kbps = Integer.parseInt(dato);
                kbps = kbps/1000;
                String speed = kbps.toString();
                font.setFontName("Verdana");
                
                if(!bolAppend){
                    font.setFontHeightInPoints((short)12);    
                    HSSFRow head = sheet.createRow((short)0);
                    head.setHeight((short) 0x250);
                    
                    HSSFCell c = null;

                    HSSFRichTextString headTxt = new HSSFRichTextString("Results dropped in by CMDownloader v0.5 by GotH(gothike) @ optinetgroup.com & tcniso.net");
                    headTxt.applyFont(HSSFFont.BOLDWEIGHT_BOLD);
                    headTxt.applyFont(font);
                    
                    HSSFCellStyle cs = wb.createCellStyle();
                    cs.setWrapText(true);
                    c = head.createCell((short)0);
                    c.setCellStyle(cs);
                    c.setCellValue(headTxt);
                            
                    Region regHead = new Region(0,(short)0,1,(short)2);
                    sheet.addMergedRegion(regHead);

                    HSSFRow row = sheet.createRow((short)2);
                    
                    font.setFontHeightInPoints((short)11);
                    HSSFRichTextString tit1 = new HSSFRichTextString("Config Filename");
                    tit1.applyFont(HSSFFont.BOLDWEIGHT_BOLD);
                    tit1.applyFont(font);
                    HSSFRichTextString tit2 = new HSSFRichTextString("Downstream");
                    tit2.applyFont(HSSFFont.BOLDWEIGHT_BOLD);
                    tit2.applyFont(font);
                    HSSFRichTextString tit3 = new HSSFRichTextString("Upstream");
                    tit3.applyFont(HSSFFont.BOLDWEIGHT_BOLD);
                    tit3.applyFont(font);
                   
                    row.createCell((short)0).setCellValue(tit1);
                    row.createCell((short)1).setCellValue(tit2);
                    row.createCell((short)2).setCellValue(tit3);
                    
                    bolAppend = true;
                    
                }
               
                
                if(name.equals(lastName)) {
                    HSSFRow row = sheet.getRow((short)rowNum);
                    font.setFontHeightInPoints((short)10);
                    HSSFRichTextString tit1 = new HSSFRichTextString(speed);
                    tit1.applyFont(font);
                    row.createCell((short)2).setCellValue(tit1);
                    rowNum++;
                } else {
                    HSSFRow row = sheet.createRow((short)rowNum);
                    font.setFontHeightInPoints((short)10);
                    HSSFRichTextString tit1 = new HSSFRichTextString(name); 
                    tit1.applyFont(font);
                    row.createCell((short)0).setCellValue(tit1);

                    HSSFRichTextString tit2 = new HSSFRichTextString(speed); 
                    tit2.applyFont(font);
                    row.createCell((short)1).setCellValue(tit2);
                }
                lastName = name;
            }
        }
        
        public final void finishProcess() throws IOException{
            jTextField2.setEnabled(true);
            jButton1.setEnabled(true);
            jButton2.setEnabled(true);
            /*Date now = new Date();
            SimpleDateFormat format = new SimpleDateFormat("yy-MM-dd");
            String today = format.format(now);
            File f=new File(".");
            String path = f.getCanonicalPath().toString();
            sheet.autoSizeColumn((short)0);
            sheet.autoSizeColumn((short)1);
            sheet.autoSizeColumn((short)3);
            
            resultFile = "results-"+today+".xls";
            
            String fullFile = path + "\\" + resultFile;
            FileOutputStream fileOut = new FileOutputStream(resultFile);
            wb.write(fileOut);
            fileOut.close();
            
            log("Finished Scan & Analyze Process!");
            log("Check your results in this file:");
            log(fullFile);*/
            statusMsg("Finished!!");
            //wishOpen();
        }
        
        public final void wishOpen() throws IOException{
            textFile = "";
            tftpIp = "";
            int pane = JOptionPane.showConfirmDialog(getFrame(), "Do you wish to open the results file in Excel now?\n(Note: Click NO if you don't have Excel installed!)","Hey...",JOptionPane.YES_NO_OPTION);
            if(pane==JOptionPane.OK_OPTION){
                File f=new File(".");
                String path = f.getCanonicalPath().toString();
                Runtime runt = Runtime.getRuntime();
                runt.exec("cmd /c start excel "+path+"\\"+resultFile);
                wishDelete();
            } else {
                wishDelete();
            }
        }
        
        public final void wishDelete() throws IOException{
            resultFile = "";
            File f=new File(".");
            String path = f.getCanonicalPath().toString() + "\\temp\\";
            int pane = JOptionPane.showConfirmDialog(getFrame(), "Do you wish to keep the config files downloaded at:" + path + "?","Hey...",JOptionPane.YES_NO_OPTION);
            if(pane!=JOptionPane.OK_OPTION){
                for(int i=0;i<downloaded.size();i++){
                    File p=new File(path+downloaded.get(i));
                    p.delete();
                }
            }
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JMenuBar menuBar;
    // End of variables declaration//GEN-END:variables
    private String appVersion;
    private JDialog aboutBox;
    private JDialog fileBox;
}


