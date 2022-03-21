# What's Object Oriented Analysis?

## Theory of Forms

<hr>

Example 1 -> People 1 says "Hello" to friend People 2 and People 2 answer as "Hi"
```java
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

    public void saySomething(human _human, String _message){
        _human.setForwardedMessage(_message);
        System.out.println(_human.getForwardedMessage());
    }

    human(String name){
        this.setName(name);
    }
}
```