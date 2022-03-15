package com.example.review.classes;

import org.springframework.stereotype.Service;

@Service /*class instanciée en mémoire (singleton). L'annotation Component est aussi la même chose*/
public class Dummy {
    public int square(int val){
        return val*val;
    }
}
