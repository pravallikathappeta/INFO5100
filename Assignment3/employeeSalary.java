
public class employeeSalary
{
    public static void main(String args[])
    {
        employeeSalary empsalary = new employeeSalary();
        empsalary.employeeSalary(60);

    }
    public double employeeSalary(double hours)
    {
        double salary=0.0;

        if (hours <=36 && hours > 0) {
            salary = hours * 15.0;
            System.out.println("Employee of salary for "+ hours +" hours is " + salary);
        }
        else{
            if(hours > 36 && hours <=41){
                salary = hours * 15 * 1.5;
                System.out.println("Employee of salary for "+ hours +" hours is "+ salary);}
            else{
                if(hours > 41 && hours <=48){
                    salary = hours * 15 * 2;
                    System.out.println("Employee of salary for "+ hours +" hours is "+ salary);}
                else{
                    System.out.println("Enter valid hours between 0 and 48.0");}}}

        return salary;
    }
}
