package br.com.dev.teste;

import br.com.dev.entity.TaxPayer;

import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);

        System.out.print("Quantos contribuintes você vai digitar?");
        int qdtContribuinte = leitura.nextInt();

        TaxPayer[] listaContribuinte = new TaxPayer[qdtContribuinte];

        for (int i = 0 ; i < qdtContribuinte ; i++){
            System.out.println("Digite os dados do " + (i+1) + "o contribuinte:");
            listaContribuinte[i] = createTaxPayer(leitura);
        }

        int ordem =1;
        for(TaxPayer contribuinte : listaContribuinte) {
            System.out.println("\nResumo do"+ ordem +"o contribuinte:");
            System.out.printf("Imposto bruto total: %.2f", contribuinte.grossTax());
            System.out.printf("\nAbatimento: %.2f", contribuinte.rebateTax());
            System.out.printf("\nImposto devido: %.2f\n", contribuinte.netTax());
            ordem++;
        }

    }

    public static TaxPayer createTaxPayer(Scanner leitura){

        System.out.print("Renda anual com salário: ");
        double salarioAnual = leitura.nextDouble();
        System.out.print("Renda anual com prestação de serviço: ");
        double servicoAnual = leitura.nextDouble();
        System.out.print("Renda anual com ganho de capital: ");
        double capitalAnual = leitura.nextDouble();
        System.out.print("Gasto Médico: ");
        double gastoMedico = leitura.nextDouble();
        System.out.print("Renda Educacional: ");
        double gastoEducacional = leitura.nextDouble();

        return new TaxPayer(salarioAnual, servicoAnual, capitalAnual, gastoMedico, gastoEducacional);
    }
}
