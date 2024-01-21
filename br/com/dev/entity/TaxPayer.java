package br.com.dev.entity;

public class TaxPayer {

    private double salaryIncome;
    private double serviceIncome;
    private double capitalIncome;
    private double healthSpending;
    private double educationSpending;

    public TaxPayer(double salaryIncome, double serviceIncome, double capitalIncome, double healthSpending, double educationSpending) {
        this.salaryIncome = salaryIncome;
        this.serviceIncome = serviceIncome;
        this.capitalIncome = capitalIncome;
        this.healthSpending = healthSpending;
        this.educationSpending = educationSpending;
    }

    public double salaryTax(){

        double salario = this.salaryIncome/12;
        if(salario >= 5000)
        {
            return (this.salaryIncome * 0.20);
        } else if (salario < 5000 && salario >= 3000) {
            return (this.salaryIncome * 0.10);
        }

        return 0.00;
    }

    public double serviceTax(){
        if (this.serviceIncome > 0.00)
            return this.serviceIncome * 0.15;

        return 0.00;
    }

    public double capitalTax(){
        if (capitalIncome > 0.00)
            return capitalIncome * 0.20;

        return 0.00;
    }

    public double grossTax(){
        return (salaryTax() + serviceTax() +capitalTax());
    }

    public double rebateTax(){

        double maxRebateTax = grossTax() * 0.30;
        double sumSpending = this.educationSpending + this.healthSpending;
        if (sumSpending >= maxRebateTax){
            return maxRebateTax;
        }

        return sumSpending;
    }

    public double netTax(){

        return grossTax() - rebateTax();
    }

}
