public class Ticket {
    private int seat;
    private  int price ;
    private char row;
    private Person person;

    public static char getSeatRow(int rowNum) {
        if (rowNum == 0) {
            return 'A';
        } else if (rowNum == 1) {
            return 'B';
        } else if (rowNum == 2) {
            return 'C';
        } else
            return 'D';
    }



    Ticket(char row, int seat, int price, Person person){
        this.row= row;
        this.seat =seat;
        this.price = price;
        this.person = person;

    }

    public int getRow(){
        return row;
    }
    public int getRowInChar(){
        if(row == 'A'){
            return 0;
        }
        else if (row=='B') {
            return 1;
        } else if (row=='C') {
            return 2;
        }else return 3;
    }
    public int getSeat(){
        return seat;
    }

    public int getPrice() {
        return price;
    }


    public void setRow(char row) {
        this.row = row;
    }
    public void setSeat(int row){
        this.seat =seat;

    }
    public void setPrice(int price){
        this.price = price;
    }
    public void setPerson(){

        this.person =person;
    }
    public String toStrige(){
     String ticketData="name :"+person.getName()+"\n"+"Seat Number :"+seat+"\n"+"Row Number :"+row+"\n"+"Price :"+price;
       return ticketData;
   }

   public String toStrigePerson(){
        String personData ="surname :"+ person.getSurname()+"\n"+"Email address :"+person.getEmail();
     return personData;
   }

}
