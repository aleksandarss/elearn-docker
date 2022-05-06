package com.acalic.elearndocker.repo;

import java.io.Serializable;

public class Fibonacci implements Serializable {
    int result;

    public Fibonacci(int result) {
        this.result = result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public int getResult() {
        return this.result;
    }
}
