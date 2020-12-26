class EmpWage {
        //constant
        public static final int IS_FULL_TIME = 1;
        public static final int IS_PART_TIME = 2;

		private final String company;
		private final int empRatePerHr;
		private final int numberOfWorkingDays;
		private final int maxHrPerMonth;
		private int totalEmpWage;

		public EmpWage(String company, int empRatePerHr, int numberOfWorkingDays, int maxHrPerMonth) {
			this.company = company;
			this.empRatePerHr = empRatePerHr;
			this.numberOfWorkingDays = numberOfWorkingDays;
			this.maxHrPerMonth = maxHrPerMonth;

		}//constructor
        
        public void empSalary() {
                //variables

		int empHrs = 0;
		int totalEmpHrs = 0;
		int totalWorkingDays = 0;
		//int totalEmpWage = 0;
		//computation
		while (totalEmpHrs <= maxHrPerMonth && totalWorkingDays < numberOfWorkingDays) {

			totalWorkingDays++;
			double empCheck = Math.floor(Math.random() * 10) % 3;
			switch ((int)empCheck)
                        {
        	                case IS_FULL_TIME :
                	                empHrs = 8;
                                        break;
                                case IS_PART_TIME :
                                        empHrs = 4;
                                        break;
                                default :
                                        empHrs = 0;

			}//switch
			totalEmpHrs += empHrs;
			System.out.println(totalWorkingDays+" "+totalEmpHrs);
		}//while
        	totalEmpWage = totalEmpHrs * empRatePerHr;
          
        }//empSalary()
		public String toString() {
			return "Total employee wage for: " +company+ " is " +totalEmpWage;
		}


        public static void main(String[] args) {
                EmpWage dMart = new EmpWage("DMart", 20, 20, 100);
		EmpWage icici = new EmpWage("icici", 50, 20, 100);
                dMart.empSalary();
		System.out.println(dMart);
		icici.empSalary();
		System.out.println(icici);
        }//main()
}//class
