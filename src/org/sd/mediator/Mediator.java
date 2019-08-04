package org.sd.mediator;

public interface Mediator {
    void register(String dname,Department p);
    void command(String dname);
}
