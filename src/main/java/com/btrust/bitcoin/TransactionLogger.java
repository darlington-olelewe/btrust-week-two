package com.btrust.bitcoin;

import org.bitcoinj.core.*;
import org.bitcoinj.params.TestNet3Params;

import java.util.List;
import java.util.logging.Logger;

public class TransactionLogger {

    private final Transaction transaction;
    private final Logger logger;

    public TransactionLogger(String hexCode){
        NetworkParameters params = TestNet3Params.get();
        byte[] rawTransaction = Utils.HEX.decode(hexCode);
        this.transaction = new Transaction(params, rawTransaction);
        this.logger = Logger.getLogger(TransactionLogger.class.getName());
    }

    public Long versionLogger(){
        return this.transaction.getVersion();
    }

    public List<TransactionInput> inputLogger(){
        return this.transaction.getInputs();
    }

    public List<TransactionOutput> outputLogger(){
        return this.transaction.getOutputs();
    }

    public Long lockTimeLogger(){
        return this.transaction.getLockTime();
    }

    public void logAllInfo(){
        logger.info("Logging To The Console");
        System.out.println(customLoggerBuilder("=> version   = "+this.versionLogger()));
        System.out.println(customLoggerBuilder("=> input(s)  = "+this.inputLogger()));
        System.out.println(customLoggerBuilder("=> output(s) = "+this.outputLogger()));
        System.out.println(customLoggerBuilder("=> lock_time = "+this.lockTimeLogger()));
    }

    private String customLoggerBuilder(String info){
        int maxLen = info.length()+3;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < maxLen; i++){
            sb.append("*");
        }
        sb.append("\n").append(info).append(" ||").append("\n");
        for(int i = 0; i < maxLen; i++){
            sb.append("*");
        }
        return sb.toString();
    }

}
