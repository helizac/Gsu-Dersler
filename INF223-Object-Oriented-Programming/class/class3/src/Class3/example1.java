package Class3;

import java.util.ArrayList;

public class example1 {
    public static void main(String[] args){
        human people1 = new human("People 1");
        human people2 = new human("People 2");
        people1.setFriends(people2);
        people2.setFriends(people1);
        people1.saySomething(people2, "Hello");
        people2.saySomething(people1, "Hi");
    }
}

class human{
    private String name;
    private String forwardedMessage;
    private ArrayList<human> friends = new ArrayList<human>();

    public void setName(String _name){this.name = name;}
    public String getName(){return this.name;}

    public void setForwardedMessage(String _forwardedMessage){this.forwardedMessage = _forwardedMessage;}
    public String getForwardedMessage(){return this.forwardedMessage;}

    public void setFriends(human newFriends){this.friends.add(newFriends);}
    public ArrayList<human> getFriends(){return this.friends;}

    public boolean isFriend(human _human){
        if(this.getFriends().indexOf(_human) != -1){
            return true;
        }
        return false;
    }

    public void saySomething(human _human, String _message){
        if(this.isFriend(_human)){
            _human.setForwardedMessage(_message);
            System.out.println(_human.getForwardedMessage());
        }
    }

    human(String name){
        this.setName(name);
    }
}
