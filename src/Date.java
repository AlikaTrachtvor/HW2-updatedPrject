public class Date {
    /**
     * This class describes a date in a format of day/month/year
     */
    private int day;
    private int month;
    private int year;
    public Date(int year, int month, int day){
        if(year < -3999 || year > 3999)
            this.year = 0;
        else
            this.year = year;
        if(month < 1 || month > 12)
            this.month = 1;
        else
            this.month = month;
        if(day < 1 || day > 31)
            this.day = 1;
        else
            this.day = day;

    }

    public int getYear(){return this.year;}
    public int getMonth(){return this.month;}
    public int getDay(){return this.day;}
    public void setYear(int year){
        if(year < - 3999 || year > 3999)
            this.year = 0;
        else
            this.year = year;
    }
    public void setMonth(int month){
        if(month < 1 || month > 12)
            this.month = 1;
        else
            this.month = month;
    }
    public void setDay(int day){
        if(day < 1 || day > 31)
            this.day = 1;
        else
            this.day = day;
    }

    /**
     * This function compares between this object and another one and checks whether the values
     * of their attributes are equal
     * @param obj the other object we're comparing the current object to
     * @return true if their attributes are completely equal and false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Date) || obj == null)
            return false;
        else if (this.hashCode() != obj.hashCode())
            return false;
        else
            return true;
    }

    private boolean isLeapYear(int year){
        if(year % 400 == 0 || (year % 4 == 0 && year % 100 != 0))
            return true;
        return false;
    }
    private int daysInMonth(int month){
        if(month == 2 && isLeapYear(this.year))
            return 29;
        else if(month == 2)
            return 28;
        else if((month < 8 && month % 2 == 1) || (month >= 8 && month % 2 == 0))
            return 31;
        else
            return 30;
    }


    //First try, needs to be checked
    //hashCode = how many days passed since 00/00/0000
    @Override
    public int hashCode(){
        int hash = 0;
        if(this.year >= 0){
            if(isLeapYear(this.year - 1))
                hash += (this.year - 1) * 366;
            else
                hash += (this.year - 1) * 365;
            for(int m = 1; m < this.month; m++)
                hash += daysInMonth(m);
            hash += this.day;
        }
        else{
            if(isLeapYear(this.year - 1))
                hash += (this.year - 1) * (-366);
            else
                hash += (this.year - 1) * (-365);
            for(int m = 1; m < this.month; m++)
                hash += daysInMonth(m);
            hash += this.day;
            hash *= -1;
        }
        return hash;
    }

    /**
     * This function takes the object's information and represents it as a String
     * @return a String representing a date in the following format: DD/MM/YYYY
     */
    @Override
    public String toString(){
        String date = "";
        if(this.day < 10)
            date += "0" + this.day + "/";
        else
            date += this.day + "/";
        if(this.month < 10)
            date += "0" + this.month + "/";
        else
            date += this.month + "/";
        if(this.year >= 0){
            if(this.year < 10)
                date += "000" + this.year;
            else if(this.year < 100)
                date += "00" + this.year;
            else if(this.year < 1000)
                date += "0" + this.year;
            else
                date += this.year;
        }
        else{
            int yearPos = this.year * (-1);
            if(yearPos < 10)
                date += "-000" + yearPos;
            else if(yearPos < 100)
                date += "-00" + yearPos;
            else if(yearPos < 1000)
                date += "-0" + yearPos;
            else
                date += "-" + yearPos;
        }
        return date;
    }
}

