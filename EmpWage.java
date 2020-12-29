import java.util.ArrayList;
class CompanyEmpWage {
	public final String company;
	public final int empRatePerHr;
	public final int numberOfWorkingDays;
	public final int maxHrPerMonth;
	public int totalEmpWage;
	ArrayList<Integer> dailyWage=new ArrayList<Integer>();
	public CompanyEmpWage(String company, int empRatePerHr, int numberOfWorkingDays, int maxHrPerMonth) {
		this.company = company;
		this.empRatePerHr = empRatePerHr;
		this.numberOfWorkingDays = numberOfWorkingDays;
		this.maxHrPerMonth = maxHrPerMonth;

	}//constructor
	public void setTotalEmpWage(int totalEmpWage) {
		this.totalEmpWage = totalEmpWage;
	}
	public String toString() {
			return "Total employee wage for: " +company+ " is " +totalEmpWage;
	}
}

class EmpWage {
        //constant
        public static final int IS_FULL_TIME = 1;
        public static final int IS_PART_TIME = 2;
		int daySalary;
	private int numOfCompany = 0;
	ArrayList<Integer> dailyWage=new ArrayList<Integer>();
	private ArrayList<CompanyEmpWage> companyEmpWageArrayList;
	public EmpWage() {
		companyEmpWageArrayList = new ArrayList<>();

	}
	public void dailyWage(){
		dailyWage.add(daySalary);
	}
	private void addCompanyEmpWage(String company, int empRatePerHr, int numberOfWorkingDays, int maxHrPerMonth) {
		CompanyEmpWage companyEmpWage = new CompanyEmpWage(company, empRatePerHr, numberOfWorkingDays, maxHrPerMonth);
		companyEmpWageArrayList.add(companyEmpWage);
		//numOfCompany++;


	}
	private void computeEmpWage() {
		for (int i=0; i<companyEmpWageArrayList.size(); i++) {
			CompanyEmpWage companyEmpWage = companyEmpWageArrayList.get(i);
			companyEmpWage.setTotalEmpWage(this.computeEmpWage(companyEmpWage));
			System.out.println(companyEmpWage);
		}
	}
       	private int computeEmpWage(CompanyEmpWage companyEmpWage) {
                //variables

		int empHrs = 0;
		int totalEmpHrs = 0;
		int totalWorkingDays = 0;
		//int totalEmpWage = 0;

		//computation
		while (totalEmpHrs <= companyEmpWage.maxHrPerMonth && totalWorkingDays < companyEmpWage.numberOfWorkingDays) {

			totalWorkingDays++;
			double empCheck = Math.floor(Math.random() * 10) % 3;
			switch ((int)empCheck) {
                        	case IS_FULL_TIME :
                                        empHrs = 8;
                                        break;
                                case IS_PART_TIME :
                                        empHrs = 4;
                                        break;
                                default :
                                        empHrs = 0;

			}//switch
			int daySalary=empHrs*companyEmpWage.empRatePerHr;
				companyEmpWage.dailyWage.add(daySalary);
			totalEmpHrs += empHrs;
			System.out.println("totalWorkingDays: "+totalWorkingDays+"/ daly empHrs: "+empHrs+"/ totalEmpHrs: "+totalEmpHrs);
		}//while
		System.out.println(companyEmpWage.dailyWage);
		return totalEmpHrs * companyEmpWage.empRatePerHr;


        }//empSalary()
		//public String toString() {
		//	return "Total employee wage for: " +company+ "is " +totalEmpWage;
		//}


        public static void main(String[] args) {
        	EmpWage empWageBuilder = new EmpWage();
		empWageBuilder.addCompanyEmpWage("icici", 50, 2, 100);
		empWageBuilder.addCompanyEmpWage("DMart", 20, 4, 100);
		empWageBuilder.addCompanyEmpWage("accenture", 20, 6, 100);
		empWageBuilder.addCompanyEmpWage("IBM", 100, 8, 100);
		empWageBuilder.addCompanyEmpWage("google", 100, 10, 100);
		empWageBuilder.computeEmpWage();
        }//main()
}//class
