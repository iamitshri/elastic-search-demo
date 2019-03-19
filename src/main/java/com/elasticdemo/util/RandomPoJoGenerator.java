package com.elasticdemo.util;

import java.time.LocalDate;
import org.jeasy.random.EasyRandom;
import org.jeasy.random.EasyRandomParameters;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RandomPoJoGenerator {

    static LocalDate today = LocalDate.now();
    private static EasyRandomParameters parameters = new EasyRandomParameters().seed(123L)
                                                                               .objectPoolSize(100)
                                                                               .randomizationDepth(15)
                                                                               .stringLengthRange(5, 25)
                                                                               .collectionSizeRange(1, 10)
                                                                               .scanClasspathForConcreteTypes(true)
                                                                               .overrideDefaultInitialization(false)
                                                                               .dateRange(today.minusDays(7),
                                                                                       today.plusDays(3));

    static EasyRandom easyRandom = new EasyRandom(parameters);



    public static <T> T getEntity(Class<T> className) {
        return easyRandom.nextObject(className);
    }

}
