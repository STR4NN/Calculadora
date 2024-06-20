import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorApp {
    public static void main(String[] args) {
        // Criação da janela principal da aplicação
        JFrame janela = new JFrame("Calculadora");
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setSize(400, 300);
        janela.setLayout(null);

        // Criação e posicionamento do label e campo de texto para o primeiro número
        JLabel labelNum1 = new JLabel("Número 1:");
        labelNum1.setBounds(50, 30, 80, 25);
        janela.add(labelNum1);

        JTextField campoNum1 = new JTextField();
        campoNum1.setBounds(150, 30, 165, 25);
        janela.add(campoNum1);

        // Criação e posicionamento do label e campo de texto para o segundo número
        JLabel labelNum2 = new JLabel("Número 2:");
        labelNum2.setBounds(50, 70, 80, 25);
        janela.add(labelNum2);

        JTextField campoNum2 = new JTextField();
        campoNum2.setBounds(150, 70, 165, 25);
        janela.add(campoNum2);

        // Criação e posicionamento dos botões de operação
        JButton botaoAdicionar = new JButton("Adicionar");
        botaoAdicionar.setBounds(50, 110, 100, 25);
        janela.add(botaoAdicionar);

        JButton botaoSubtrair = new JButton("Subtrair");
        botaoSubtrair.setBounds(160, 110, 100, 25);
        janela.add(botaoSubtrair);

        JButton botaoMultiplicar = new JButton("Multiplicar");
        botaoMultiplicar.setBounds(270, 110, 100, 25);
        janela.add(botaoMultiplicar);

        JButton botaoDividir = new JButton("Dividir");
        botaoDividir.setBounds(50, 150, 100, 25);
        janela.add(botaoDividir);

        // Criação e posicionamento do label e campo de texto para o resultado
        JLabel labelResultado = new JLabel("Resultado:");
        labelResultado.setBounds(50, 190, 80, 25);
        janela.add(labelResultado);

        JTextField campoResultado = new JTextField();
        campoResultado.setBounds(150, 190, 165, 25);
        campoResultado.setEditable(false); // Tornando o campo de resultado não editável
        janela.add(campoResultado);

        // Adicionando ação ao botão de adição
        botaoAdicionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Pega os números dos campos de texto
                double num1 = Double.parseDouble(campoNum1.getText());
                double num2 = Double.parseDouble(campoNum2.getText());
                // Cria uma instância da classe Addition e realiza a adição
                Addition adicao = new Addition();
                double resultado = adicao.add(num1, num2);
                // Define o resultado no campo de resultado
                campoResultado.setText(Double.toString(resultado));
            }
        });

        // Adicionando ação ao botão de subtração
        botaoSubtrair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Pega os números dos campos de texto
                double num1 = Double.parseDouble(campoNum1.getText());
                double num2 = Double.parseDouble(campoNum2.getText());
                // Cria uma instância da classe Subtraction e realiza a subtração
                Subtraction subtracao = new Subtraction();
                double resultado = subtracao.subtract(num1, num2);
                // Define o resultado no campo de resultado
                campoResultado.setText(Double.toString(resultado));
            }
        });

        // Ação ao botao clicar
        botaoMultiplicar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Pega os números dos campos de texto
                double num1 = Double.parseDouble(campoNum1.getText());
                double num2 = Double.parseDouble(campoNum2.getText());
                // Cria uma instância da classe Multiplication e realiza a multiplicação
                Multiplication multiplicacao = new Multiplication();
                double resultado = multiplicacao.multiply(num1, num2);
                // Define o resultado no campo de resultado
                campoResultado.setText(Double.toString(resultado));
            }
        });

        // Adicionando ação ao botão de divisão
        botaoDividir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Pega os números dos campos de texto
                double num1 = Double.parseDouble(campoNum1.getText());
                double num2 = Double.parseDouble(campoNum2.getText());
                // Cria uma instância da classe Division e realiza a divisão
                Division divisao = new Division();
                try {
                    double resultado = divisao.divide(num1, num2);
                    // Define o resultado no campo de resultado
                    campoResultado.setText(Double.toString(resultado));
                } catch (ArithmeticException ex) {
                    // Trata a exceção de divisão por zero
                    campoResultado.setText("Erro: " + ex.getMessage());
                }
            }
        });

        // Torna a janela visível
        janela.setVisible(true);
    }
}