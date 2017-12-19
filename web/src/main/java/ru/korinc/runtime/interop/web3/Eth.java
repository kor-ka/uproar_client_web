package ru.korinc.runtime.interop.web3;

import jsinterop.annotations.JsType;

/**
 * Created by gputintsev on 19.12.17.
 */

@JsType(name = "eth")
public class Eth {

    public Eth() {
    }

    //TODO add wait web3 method

    public native void getBalance(BalanceCallback callback)/*-{
        var coinbase = $wnd.web3.eth.coinbase
        console.log(coinbase)
        var balance = $wnd.web3.eth.getBalance(coinbase, function(error, result){
            if(!error){

                callback.@ru.korinc.runtime.interop.web3.Eth.BalanceCallback::onBalance(Ljava/lang/Double;)(result);
                console.log(result)
            }else{
                console.error(error);
                }
        })
   }-*/;

   public native boolean loggedIn()/*-{
        var coinbase = $wnd.web3.eth.coinbase
       return coinbase!=null;
   }-*/;

    public interface BalanceCallback {

        void onBalance(Double balance);
    }
}
