package com.sparta.sj.Searchers.Exceptions;


public class NodeNotFoundException extends Exception {

    public NodeNotFoundException() { super(); }

    public NodeNotFoundException(String message) { super(message); }

    public NodeNotFoundException(String message, Throwable cause) { super(message, cause); }

    public NodeNotFoundException(Throwable cause) { super(cause); }
}
