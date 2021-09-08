package com.aa.workshop;

public class Chef {
    private Tool tool;

    public Chef(String firstName, String lastName) {

    }

    public void hold(Tool tool) {
        this.tool = tool;
    }

    public String action() {
        return this.tool.action();
    }
}
