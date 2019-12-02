package com.example.test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Optional;

/**
 * @author: lingjun.jlj
 * @date: 2019/11/9 23:37
 * @description:
 */
public class SerializationTest {

    static class My implements Serializable {
        private Optional i;

        private static final long serialVersionUID = 1L;
        Optional<Integer> value = Optional.empty();

        public void setValue(Integer i) {
            this.i = Optional.of(i);
        }

        public Optional<Integer> getValue() {
            return value;
        }
    }

    public static <T extends Serializable> byte[] toBytes(T reportInfo) {
        try (ByteArrayOutputStream bstream = new ByteArrayOutputStream()) {
            try (ObjectOutputStream ostream = new ObjectOutputStream(bstream)) {
                ostream.writeObject(reportInfo);
            }
            return bstream.toByteArray();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        My my = new My();
        byte[] bytes = toBytes(my);
    }
}
