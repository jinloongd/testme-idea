package com.example.services.impl

import com.example.beans.JavaBean
import com.example.foes.Fear
import com.example.foes.Fire
import com.example.foes.Ice
import com.example.groovies.Groove
import com.example.groovies.ImGroovy
import com.example.groovies.ImGroovyWithTupleCtor
import com.example.warriers.FooFighter
import org.junit.Test
import org.junit.Before
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import static org.mockito.Mockito.*

/** created by TestMe integration test on MMXVI */
class FooTest {
    @Mock
    FooFighter fooFighter
    @InjectMocks
    Foo foo

    @Before
    void setUp() {
        MockitoAnnotations.initMocks(this)
    }

    @Test
    void testFind() {
        Collection<ImGroovyWithTupleCtor> result = foo.find([new ImGroovyWithTupleCtor("myName", new Ice(), [new JavaBean(myString: "myString", myDate: new GregorianCalendar(2016, Calendar.JANUARY, 11, 22, 45).getTime(), someNum: 0, someLongerNum: 1l, fear: new Fear(), fire: new Fire(), ice: new Ice(), myOtherString: "myOtherString", someBinaryOption: true)])], new ImGroovy(groove: new Groove(someString: "someString", ice: new Ice()), myName: "myName", ice: new Ice(), myBeans: [new JavaBean(myString: "myString", myDate: new GregorianCalendar(2016, Calendar.JANUARY, 11, 22, 45).getTime(), someNum: 0, someLongerNum: 1l, fear: new Fear(), fire: new Fire(), ice: new Ice(), myOtherString: "myOtherString", someBinaryOption: true)]))
        assert result == [new ImGroovyWithTupleCtor("myName", new Ice(), [new JavaBean(myString: "myString", myDate: new GregorianCalendar(2016, Calendar.JANUARY, 11, 22, 45).getTime(), someNum: 0, someLongerNum: 1l, fear: new Fear(), fire: new Fire(), ice: new Ice(), myOtherString: "myOtherString", someBinaryOption: true)])]
    }
}

//Generated with love by TestMe :) Please raise issues & feature requests at: https://weirddev.com/forum#!/testme