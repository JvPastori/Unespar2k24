import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class trab {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Trab de Física");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(450, 350);
        frame.setLayout(new BorderLayout());

        JPanel panelEntrada = new JPanel();
        panelEntrada.setLayout(new GridLayout(2, 2, 10, 10));
        panelEntrada.setBorder(BorderFactory.createEmptyBorder(20, 20, 10, 20));

        JLabel labelPotencia = new JLabel("Multiplicação da Potência:");
        JTextField campoPotencia = new JTextField();
        JLabel labelCorrente = new JLabel("Multiplicação da Corrente:");
        JTextField campoCorrente = new JTextField();

        panelEntrada.add(labelPotencia);
        panelEntrada.add(campoPotencia);
        panelEntrada.add(labelCorrente);
        panelEntrada.add(campoCorrente);

        JPanel panelSaida = new JPanel();
        panelSaida.setLayout(new GridLayout(2, 2, 10, 10));
        panelSaida.setBorder(BorderFactory.createEmptyBorder(10, 20, 20, 20));

        JLabel labelNovoComprimento = new JLabel("Novo Comprimento (L'): ");
        JTextField campoNovoComprimento = new JTextField();
        campoNovoComprimento.setEditable(false);
        JLabel labelNovaSecao = new JLabel("Nova Seção (A'): ");
        JTextField campoNovaSecao = new JTextField();
        campoNovaSecao.setEditable(false);

        panelSaida.add(labelNovoComprimento);
        panelSaida.add(campoNovoComprimento);
        panelSaida.add(labelNovaSecao);
        panelSaida.add(campoNovaSecao);

        JButton botaoCalcular = new JButton("Calcular");
        botaoCalcular.setPreferredSize(new Dimension(120, 40));

        JPanel panelBotao = new JPanel();
        panelBotao.add(botaoCalcular);

        botaoCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double multiplicacaoPotencia = Double.parseDouble(campoPotencia.getText());
                    double multiplicacaoCorrente = Double.parseDouble(campoCorrente.getText());

                    double razaoL = Math.sqrt(multiplicacaoCorrente);
                    double razaoA = multiplicacaoCorrente / multiplicacaoPotencia;

                    campoNovoComprimento.setText(String.format("%.2f", razaoL));
                    campoNovaSecao.setText(String.format("%.2f", razaoA));

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Por favor, insira valores numéricos válidos.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        frame.add(panelEntrada, BorderLayout.NORTH);
        frame.add(panelSaida, BorderLayout.CENTER);
        frame.add(panelBotao, BorderLayout.SOUTH);

        frame.setVisible(true);
    }
}
