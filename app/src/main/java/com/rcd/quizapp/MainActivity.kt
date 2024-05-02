package com.rcd.quizapp


import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView


class MainActivity : AppCompatActivity() {
//    variables declaration
    var textview1: TextView? = null
    var scoreDisplay : TextView? = null
    var image: ImageView? = null
    var button1: Button? = null
    var button2: Button? = null
    var button3: Button? = null
    var button4: Button? = null
    var summit: Button? = null
    var answer: String = ""
    var index: Int = 0
    var click: Button? = null
    var score: Int = 0
    var nextButton : Button? = null
    var replay : Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        append the id in all variables
        setContentView(R.layout.activity_main)
        scoreDisplay = findViewById(R.id.score)
        textview1 = findViewById(R.id.text1)
        image = findViewById(R.id.image)
        summit = findViewById(R.id.summit)
        button1 = findViewById(R.id.button1)
        button2 = findViewById(R.id.button2)
        button3 = findViewById(R.id.button3)
        button4 = findViewById(R.id.button4)
        nextButton = findViewById(R.id.clear)
        replay = findViewById(R.id.replay)

        button1?.isClickable = false
        button2?.isClickable = false
        button3?.isClickable = false
        button4?.isClickable = false

        replay?.visibility = View.INVISIBLE
        button1?.visibility = View.INVISIBLE
        button2?.visibility = View.INVISIBLE
        button3?.visibility = View.INVISIBLE
        button4?.visibility = View.INVISIBLE
        summit?.visibility = View.INVISIBLE
        image?.visibility = View.INVISIBLE

        //option one button
        button1?.setOnClickListener {
            click = button1

            button1?.setTextColor(Color.WHITE)
            button1?.setTextColor(Color.WHITE)
            button2?.setTextColor(Color.BLACK)
            button3?.setTextColor(Color.BLACK)
            button4?.setTextColor(Color.BLACK)

            button1?.setBackgroundColor(Color.BLUE)
            button2?.setBackgroundColor(Color.WHITE)
            button3?.setBackgroundColor(Color.WHITE)
            button4?.setBackgroundColor(Color.WHITE)

            summit?.isClickable = true
        }
        //option two button
        button2?.setOnClickListener {
            click = button2
            button1?.setBackgroundColor(Color.WHITE)
            button2?.setBackgroundColor(Color.BLUE)
            button3?.setBackgroundColor(Color.WHITE)
            button4?.setBackgroundColor(Color.WHITE)

            button1?.setTextColor(Color.BLACK)
            button2?.setTextColor(Color.WHITE)
            button3?.setTextColor(Color.BLACK)
            button4?.setTextColor(Color.BLACK)
            summit?.isClickable = true
        }
        //option three button
        button3?.setOnClickListener {
            click = button3
            button1?.setBackgroundColor(Color.WHITE)
            button2?.setBackgroundColor(Color.WHITE)
            button3?.setBackgroundColor(Color.BLUE)
            button4?.setBackgroundColor(Color.WHITE)

            button1?.setTextColor(Color.BLACK)
            button2?.setTextColor(Color.BLACK)
            button3?.setTextColor(Color.WHITE)
            button4?.setTextColor(Color.BLACK)
            summit?.isClickable = true
        }
        //option four button
        button4?.setOnClickListener {
            click = button4
            button1?.setBackgroundColor(Color.WHITE)
            button2?.setBackgroundColor(Color.WHITE)
            button3?.setBackgroundColor(Color.WHITE)
            button4?.setBackgroundColor(Color.BLUE)

            button1?.setTextColor(Color.BLACK)
            button2?.setTextColor(Color.BLACK)
            button3?.setTextColor(Color.BLACK)
            button4?.setTextColor(Color.WHITE)
            summit?.isClickable = true
        }
        // summit button and check the answer in user input
        summit?.setOnClickListener {
            button1?.isClickable = false
            button2?.isClickable = false
            button3?.isClickable = false
            button4?.isClickable = false
            nextButton?.isClickable = true

            if (answer == click?.text) {
                click?.setBackgroundColor(Color.GREEN)
                click?.setTextColor(Color.BLACK)
                score++
            }

            else {
                click?.setBackgroundColor(Color.RED)
                when (answer) {
                    button1?.text -> button1?.setBackgroundColor(Color.GREEN)
                    button2?.text -> button2?.setBackgroundColor(Color.GREEN)
                    button3?.text -> button3?.setBackgroundColor(Color.GREEN)
                    else -> button4?.setBackgroundColor(Color.GREEN)
                }

            }
        }

    }
//    set question part
    fun setQuestion() {

        button1?.isClickable = true
        button2?.isClickable = true
        button3?.isClickable = true
        button4?.isClickable = true
        click = null

        scoreDisplay?.text = "Identify the animal by picture"

        val quesList = listOf(arrayOf("Lion", "Cat", "Tiger", "Bear", "Bear"),
            arrayOf("Cat", "Cow", "Tiger", "Lion", "Cat"),
            arrayOf("Horse", "Cheetah", "Polar Bear", "Tiger", "Cheetah"),
            arrayOf("cow", "dog", "Pig", "cat", "cow"),
            arrayOf("Tiger", "dog", "Donkey", "Lion", "dog"),
            arrayOf("donkey", "dog", "Pig", "cat", "donkey"),
            arrayOf("Horse", "Elephant", "Polar Bear", "Tiger", "Elephant"),
            arrayOf("Lion", "Cat", "Horse", "Bear", "Horse"),
            arrayOf("Tiger", "Cow", "Donkey", "Lion", "Lion"),
            arrayOf("Horse", "Cheetah", "Polar Bear", "Elephant", "Polar Bear")
        )

        val images = listOf(
            R.drawable.bear,
            R.drawable.cat,
            R.drawable.cheetah,
            R.drawable.cow,
            R.drawable.dog,
            R.drawable.donkey,
            R.drawable.elephant,
            R.drawable.horse,
            R.drawable.lion,
            R.drawable.polarbear
        )

        image?.setImageResource(images[index])
        button1?.text = quesList[index][0]
        button2?.text = quesList[index][1]
        button3?.text = quesList[index][2]
        button4?.text = quesList[index][3]
        answer = quesList[index][4]
        button1?.setBackgroundColor(Color.WHITE)
        button2?.setBackgroundColor(Color.WHITE)
        button3?.setBackgroundColor(Color.WHITE)
        button4?.setBackgroundColor(Color.WHITE)
        index++
    }

    fun next(view: View) {
        nextButton?.text = "Next"
        nextButton?.isClickable = false
        button1?.isClickable = true
        button2?.isClickable = true
        button3?.isClickable = true
        button4?.isClickable = true
        button1?.visibility = View.VISIBLE
        button2?.visibility = View.VISIBLE
        button3?.visibility = View.VISIBLE
        button4?.visibility = View.VISIBLE
        summit?.visibility = View.VISIBLE
        image?.visibility = View.VISIBLE

        summit?.text="submit"
        summit?.setBackgroundColor(Color.GRAY)
        summit?.setTextColor(Color.WHITE)
        summit?.isClickable=false
        if (index == 9) {
            button1?.visibility = View.INVISIBLE
            button2?.visibility = View.INVISIBLE
            button3?.visibility = View.INVISIBLE
            button4?.visibility = View.INVISIBLE
            summit?.visibility = View.INVISIBLE
            nextButton?.visibility = View.INVISIBLE
            scoreDisplay?.text = "YOUR SCORE IS : $score"
            image?.setImageResource(R.drawable.img_2)
            textview1?.text = "\uD83C\uDF38 \uD83C\uDF38 THANK YOU \uD83C\uDF38 \uD83C\uDF38"

            replay?.setBackgroundColor(Color.GRAY)
            replay?.setTextColor(Color.WHITE)
            replay?.visibility = View.VISIBLE

       }
        else {
            summit?.text = "submit"
            setQuestion()
        }
        button1?.setTextColor(Color.BLACK)
        button2?.setTextColor(Color.BLACK)
        button3?.setTextColor(Color.BLACK)
        button4?.setTextColor(Color.BLACK)
    }
    fun replay(view: View){
        index = 0
        score = 0
        setQuestion()
        button1?.setTextColor(Color.BLACK)
        button2?.setTextColor(Color.BLACK)
        button3?.setTextColor(Color.BLACK)
        button4?.setTextColor(Color.BLACK)
        summit?.setTextColor(Color.WHITE)
        summit?.setBackgroundColor(Color.GRAY)
        replay?.visibility = View.INVISIBLE
        button1?.visibility = View.VISIBLE
        button2?.visibility = View.VISIBLE
        button3?.visibility = View.VISIBLE
        button4?.visibility = View.VISIBLE
        summit?.visibility = View.VISIBLE
        nextButton?.visibility = View.VISIBLE
        textview1?.text = ""
    }
}