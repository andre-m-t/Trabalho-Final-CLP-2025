package Telas;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class PainelComImagem extends JPanel {

    private Image imagem;

    public PainelComImagem() {
        // Substitua esse caminho pelo caminho real da sua imagem na pasta src
        imagem = new ImageIcon(getClass().getResource("/Assets/EntortasBarSimulation/New_Background.png")).getImage();
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Desenha a imagem preenchendo o tamanho do painel
        g.drawImage(imagem, 0, 0, getWidth(), getHeight(), this);
    }
}
