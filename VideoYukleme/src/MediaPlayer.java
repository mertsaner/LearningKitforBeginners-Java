
import java.awt.BorderLayout;
import java.awt.Component;
import java.net.MalformedURLException;
import java.net.URL;
import javax.media.Manager;
import javax.media.MediaLocator;
import javax.media.Player;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

public class MediaPlayer extends javax.swing.JFrame {

    
    public MediaPlayer(URL mediauUrl) {
        initComponents();

        setLayout(new BorderLayout());

        try {

            Player mediaPlayer = Manager.createRealizedPlayer(new MediaLocator(mediauUrl));

            Component video = mediaPlayer.getVisualComponent();

            Component control = mediaPlayer.getControlPanelComponent();

            if (video != null) {

                add(video, BorderLayout.CENTER);          // place the video component in the panel

            }

            add(control, BorderLayout.SOUTH);            // place the control in  panel

            mediaPlayer.start();

        } catch (Exception e) {

        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>                        

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        JFileChooser fileChooser = new JFileChooser();

        fileChooser.showOpenDialog(null);

        URL mediaUrl = null;

        try {

            mediaUrl = fileChooser.getSelectedFile().toURI().toURL();

        } catch (MalformedURLException ex) {

            System.out.println(ex);

        }

        JFrame mediaTest = new JFrame("Video Oynatıcı");

        mediaTest.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        MediaPlayer mediaPanel = new MediaPlayer(mediaUrl);

        mediaTest.add(mediaPanel);

        mediaTest.setSize(800, 700); // set the size of the player

        mediaTest.setLocationRelativeTo(null);

        mediaTest.setVisible(true);

    }

                  
}