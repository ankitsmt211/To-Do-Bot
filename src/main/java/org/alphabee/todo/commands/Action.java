package org.alphabee.todo.commands;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import static org.alphabee.todo.constants.Constants.todoList;

public class Action extends ListenerAdapter {


    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        super.onMessageReceived(event);
        if(event.getMessage().getContentRaw().startsWith("!add")){
            String command = event.getMessage().getContentRaw();
            String todo = command.substring(5);
            todoList.add(todo);
            event.getChannel().sendMessage("added to todoList").queue();
        }

        else if(event.getMessage().getContentRaw().equals("!clear")){
            todoList.clear();
        }

        else if(event.getMessage().getContentRaw().contains("!remove")){
            try{
                if(!event.getAuthor().isBot()){
                    int index = Integer.parseInt(event.getMessage().getContentRaw().substring(8));
                    todoList.remove(index-1);
                }

            }
            catch(Exception e){
                event.getChannel().sendMessage("Please enter command correctly, !remove index").queue();
            }


        }
    }


}
