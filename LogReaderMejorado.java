package pe.edu.unmsm.fisi.upg.ads.big_o_notation_java.ds;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

//---- SE MEJORO EL ALGORITMO MODIFICANDO EL ARREGO ARRAY_LIST CON UN HASHSET  ----- //

public class LogReaderMejorado implements Iterable<LogLine> {
    private final int sizeLogLines;
    private final int sizeUniqueIps;
    private Collection<String> uniqueIps;

    public LogReaderMejorado(int sizeLogLines, int sizeUniqueIps) {
        this.sizeLogLines = sizeLogLines;
        this.sizeUniqueIps = sizeUniqueIps;
        
      //Aquí se hace la modificación del ArrayList por un HashSet;
        this.uniqueIps = (Collection<String>) new HashSet<String>();
        
    }

    public Iterator<LogLine> iterator() {
        return new LogReaderIterator(this.sizeLogLines, this.sizeUniqueIps);
    }

    @SuppressWarnings("unused")
    public int readAllLogs() {
        int sizeLogLines = 0;
        for (LogLine line : this) {
            String ip = line.getIP();
            sizeLogLines++;
        }
        return sizeLogLines;
    }

    public int getSizeUniqueIps() {

        for (LogLine logLine : this) {
            String ip = logLine.getIP();
            if (!this.uniqueIps.contains(ip)) {
                this.uniqueIps.add(ip);
            }
        }
        return this.uniqueIps.size();
    }
}
