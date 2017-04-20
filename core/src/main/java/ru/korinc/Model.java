package ru.korinc;

import ru.korinc.runtime.RuntimeConfiguration;
import ru.korinc.runtime.logging.LogProvider;
import ru.korinc.runtime.rx.Consumer;
import ru.korinc.runtime.rx.Emitter;
import ru.korinc.runtime.rx.Function;
import ru.korinc.runtime.rx.ObservableOnSubscribe;
import ru.korinc.runtime.rx.ObservableWrapper;
import ru.korinc.runtime.rx.StringObservable;
import ru.korinc.runtime.rx.subject.BSWrapper;

import static java.lang.Math.abs;

public class Model {

    private RuntimeConfiguration configuration;

    public Model(RuntimeConfiguration configuration) {
        this.configuration = configuration;
        log = configuration.getLogProvider();
    }

    private BSWrapper<Integer> displayCount;
    private BSWrapper<Integer> counter;

    private LogProvider log;

    public ObservableWrapper<String> subscribeCount() {
        checkCountRep();
        return displayCount.map(new Function<Integer, String>() {
            @Override
            public String apply(Integer integer) {
                return integer + " <--> " + numberToWords(integer);
            }
        }).flatMap(new Function<String, ObservableWrapper<String>>() {
            @Override
            public ObservableWrapper<String> apply(String s) throws Exception {
                return getMultiplyEmitConverter(s);
            }
        });
    }

    public ObservableWrapper<String> getMultiplyEmitConverter(final String s) {
        return configuration.getRxProvider().observableCreate(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(Emitter<String> e) throws Exception {
                e.onNext(s + ": 1");
                configuration.getTimeoutProvider().sleep(600);
                e.onNext(s + ": 2");
                configuration.getTimeoutProvider().sleep(600);
                e.onNext(s + ": 3");
                configuration.getTimeoutProvider().sleep(600);
                e.onComplete();
            }
        });
    }

    private void checkCountRep() {
        if (displayCount == null) {
            displayCount = configuration.getRxProvider().bs(0);
            counter = configuration.getRxProvider().bs(0);

            counter.observeOn(configuration.getRxProvider().scheduler())
                    .subscribe(new Consumer<Integer>() {
                int current = 0;

                @Override
                public void accept(Integer integer) throws Exception {
                    current += integer;
                    log.d("Threading", Thread.currentThread().toString());
                    displayCount.onNext(current);

                }
            });
        }
    }

    public void count(final int i) {
        for (int j = 0; j < 1; j++) {
            countInternal(i);
        }
    }

    public void countInternal(final int i) {
        checkCountRep();
        configuration.getRxProvider().observableCreate(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(Emitter<Integer> e) throws Exception {
                int to1 = i;

                while (to1-- > 0) {
                    log.d("wtf", to1 + "");
                    e.onNext(1);
                    configuration.getTimeoutProvider().sleep(500);
//                    for (int j = 0; j < 100000; j++) {
//                        tan(atan(tan(atan(tan(atan(tan(atan(tan(atan(tan(atan(tan(atan(tan(atan(
//                                tan(atan(tan(atan(tan(atan(tan(atan(tan(atan(tan(atan(tan(atan(
//                                        tan(atan(tan(atan(tan(atan(tan(atan(tan(atan(tan(atan(
//                                                tan(atan(tan(atan(tan(atan(tan(atan(tan(atan(
//                                                        tan(atan(tan(atan(tan(atan(tan(atan(
//                                                                123456789.123456789))))))))))))))))))))))))))))))))))))))))))))))))))))))))))));
//                    }
                }
                e.onComplete();

            }
        }).subscribeOn(configuration.getRxProvider().scheduler())
                .subscribe(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {
                counter.onNext(integer);
            }
        });

    }

    String unitsMap[] = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight",
            "nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen",
            "seventeen", "eighteen", "nineteen"};

    String tensMap[] = {"zero", "ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy",
            "eighty", "ninety"};

    String numberToWords(int number) {
        if (number == 0) {
            return "zero";
        }

        if (number < 0) {
            return "minus " + numberToWords(abs(number));
        }

        String words = "";

        if ((number / 1000000000) > 0) {
            words += numberToWords(number / 1000000000) + " billion ";
            number %= 1000000000;
        }

        if ((number / 1000000) > 0) {
            words += numberToWords(number / 1000000) + " million ";
            number %= 1000000;
        }

        if ((number / 1000) > 0) {
            words += numberToWords(number / 1000) + " thousand ";
            number %= 1000;
        }

        if ((number / 100) > 0) {
            words += numberToWords(number / 100) + " hundred ";
            number %= 100;
        }

        if (number > 0) {
            if (number < 20) {
                words += unitsMap[number];
            } else {
                words += tensMap[number / 10];
                if ((number % 10) > 0) {
                    words += "-" + unitsMap[number % 10];
                }
            }
        }

        return words;
    }
}
