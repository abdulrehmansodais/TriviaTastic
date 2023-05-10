package com.example.triviatastic;

import static android.content.ContentValues.TAG;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class QuizActivity extends AppCompatActivity {
    private int score=0;
    private TextView questionTextView;
    private RadioGroup answerRadioGroup;
    private RadioButton answer2;
    private RadioButton answer1;
    private RadioButton answer3;
    private RadioButton answer4;
    private Button nextButton;
    private Button saveButton;

    private int currentQuestionIndex;
    private Handler mHandler = new Handler();
    private ArrayList<Question> questionList;
    private ArrayList<Question> questionList1;
    private ArrayList<Question> questionList2;


    private ArrayList <Quiz >quizzes ;
    private TextView correctAnswerTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Bundle extras = getIntent().getExtras();
        String username = getIntent().getStringExtra("username");
        String name = getIntent().getStringExtra("name");
        String email = getIntent().getStringExtra("email");
        int option=getIntent().getIntExtra("ans",0);


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        // Get references to UI elements
        questionTextView = findViewById(R.id.question_text_view);
        answerRadioGroup = findViewById(R.id.answer_radio_group);
        nextButton = findViewById(R.id.next_button);
        correctAnswerTextView = findViewById(R.id.correct_answer_textview);
        saveButton = findViewById(R.id.save);
        answer1 = findViewById(R.id.answer_option_1);
        answer2 = findViewById(R.id.answer_option_2);
        answer3 = findViewById(R.id.answer_option_3);
        answer4 = findViewById(R.id.answer_option_4);
        // Initialize current question index
        currentQuestionIndex = 0;

        // Initialize question list
        questionList = new ArrayList<>();
        questionList1 = new ArrayList<>();
        questionList2 = new ArrayList<>();
        quizzes = new ArrayList<>();
        questionList.add(new Question("What is the capital of France?", new String[]{ "Berlin", "London", "Madrid","Paris"}, 3));
        questionList.add(new Question("What is the highest mountain in the world?", new String[]{"Mount Everest", "K2", "Kangchenjunga", "Lhotse"}, 0));
        questionList.add(new Question("Who is the author of 'To Kill a Mockingbird'?", new String[]{"Harper Lee", "J.K. Rowling", "George Orwell", "Ernest Hemingway"},0));
        questionList.add(new Question("What is the largest country in the world by area?",new String[]{ "Russia", "Canada", "China", "United States"}, 0));
        quizzes.add(new Quiz(questionList));
        questionList1.add(new Question("What is 2+2?", new String[]{ "1", "2", "3","4"}, 3));
        questionList1.add(new Question("What is 10 mod 3", new String[]{"0", "1", "2", "3"}, 1));
        questionList1.add(new Question("what is 5*2", new String[]{"7", "8", "9", "10"},3));
        questionList1.add(new Question("What is 25/5",new String[]{ "3", "4", "5", "6"}, 2));
        questionList2.add(new Question("Which of the following is a unit of measurement for energy?", new String[]{ "Watt", "Meter", "Joule","Pascal"}, 2));
        questionList2.add(new Question("Which of the following is a greenhouse gas?", new String[]{"carbon dioxide", "nitrogen", "oxygen", "argon"}, 0));
        questionList2.add(new Question("Which of the following is a unit of measurement for force?", new String[]{"Meter", "Kilogram", "Newton", "Second"},2));
        questionList2.add(new Question("Which of the following is not a renewable energy source?",new String[]{ "Wind", "Coal", "solar", "hydro"}, 1));
        quizzes.add(new Quiz(questionList1));
        quizzes.add(new Quiz(questionList2));

        if(option==0)
            displayQuestion(questionList);
        if(option==1)
            displayQuestion(questionList1);
        if(option==2)
            displayQuestion(questionList2);
        // Set up button click listener
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Check if answer is selected
                if (answerRadioGroup.getCheckedRadioButtonId() == -1) {
                    Toast.makeText(QuizActivity.this, "Please select an answer", Toast.LENGTH_SHORT).show();
                } else {
                    answer1.setEnabled(false);
                    answer2.setEnabled(false);
                    answer3.setEnabled(false);
                    answer4.setEnabled(false);

                    // Check if answer is correct
                    int selectedAnswerIndex = answerRadioGroup.indexOfChild(findViewById(answerRadioGroup.getCheckedRadioButtonId()));
                    if (option==0) {
                        if (selectedAnswerIndex == questionList.get(currentQuestionIndex).getCorrectAnswerIndex()) {
                            Toast.makeText(getApplicationContext(), "Correct!!!", Toast.LENGTH_SHORT).show();
                            score = score + 10;
                        } else {
                            correctAnswerTextView.setTextColor(Color.RED);
                            int correct = questionList.get(currentQuestionIndex).getCorrectAnswerIndex();
                            String ans = "Ans is " + questionList.get(currentQuestionIndex).getAnswer(correct);
                            Toast.makeText(QuizActivity.this, "Incorrect!!!", Toast.LENGTH_SHORT).show();
                            correctAnswerTextView.setVisibility(View.VISIBLE);
                            correctAnswerTextView.setText(ans);
                        }
                    }
                    if (option==1) {
                        if (selectedAnswerIndex == questionList1.get(currentQuestionIndex).getCorrectAnswerIndex()) {
                            Toast.makeText(getApplicationContext(), "Correct!!!", Toast.LENGTH_SHORT).show();
                            score = score + 10;
                        } else {
                            correctAnswerTextView.setTextColor(Color.RED);
                            int correct = questionList1.get(currentQuestionIndex).getCorrectAnswerIndex();
                            String ans = "Ans is " + questionList1.get(currentQuestionIndex).getAnswer(correct);
                            Toast.makeText(QuizActivity.this, "Incorrect!!!", Toast.LENGTH_SHORT).show();
                            correctAnswerTextView.setVisibility(View.VISIBLE);
                            correctAnswerTextView.setText(ans);
                        }
                    }
                    if (option==2) {
                        if (selectedAnswerIndex == questionList2.get(currentQuestionIndex).getCorrectAnswerIndex()) {
                            Toast.makeText(getApplicationContext(), "Correct!!!", Toast.LENGTH_SHORT).show();
                            score = score + 10;
                        } else {
                            correctAnswerTextView.setTextColor(Color.RED);
                            int correct = questionList2.get(currentQuestionIndex).getCorrectAnswerIndex();
                            String ans = "Ans is " + questionList2.get(currentQuestionIndex).getAnswer(correct);
                            Toast.makeText(QuizActivity.this, "Incorrect!!!", Toast.LENGTH_SHORT).show();
                            correctAnswerTextView.setVisibility(View.VISIBLE);
                            correctAnswerTextView.setText(ans);
                        }
                    }
                }
            }
        });
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (answerRadioGroup.getCheckedRadioButtonId() == -1) {
                    Toast.makeText(QuizActivity.this, "Please select an answer", Toast.LENGTH_SHORT).show();
                }
                else {
                    currentQuestionIndex++;
                    if (currentQuestionIndex == questionList.size()) {
                        // Quiz is over
                        Toast.makeText(QuizActivity.this, "Quiz is over", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(QuizActivity.this, Scoring.class);
                        Log.d(TAG, "loadUserData() username is " + username);
                        Log.d(TAG, "loadUserData() name is " + name);
                        Log.d(TAG, "loadUserData() email is " + email);
                        intent.putExtra("Score", score);
                        intent.putExtra("Username", username);
                        intent.putExtra("name", name);
                        intent.putExtra("email", email);
                        startActivity(intent);
                        finish();
                    } else {
                        correctAnswerTextView.setVisibility(View.GONE);
                        if(option==0)
                            displayQuestion(questionList);
                        if(option==1)
                            displayQuestion(questionList1);
                        if(option==2)
                            displayQuestion(questionList2);
                    }
                    answer1.setEnabled(true);
                    answer2.setEnabled(true);
                    answer3.setEnabled(true);
                    answer4.setEnabled(true);
                }

            }
        });
    }

    private void displayQuestion(ArrayList<Question> questionLis) {
        // Display current question and answer opti
        // ons
        Question currentQuestion = questionLis.get(currentQuestionIndex);
        questionTextView.setText(currentQuestion.getText());
        ((RadioButton) answerRadioGroup.getChildAt(0)).setText(currentQuestion.getAnswerOption1());
        ((RadioButton) answerRadioGroup.getChildAt(1)).setText(currentQuestion.getAnswerOption2());
        ((RadioButton) answerRadioGroup.getChildAt(2)).setText(currentQuestion.getAnswerOption3());
        ((RadioButton) answerRadioGroup.getChildAt(3)).setText(currentQuestion.getAnswerOption4());
        answerRadioGroup.clearCheck();

    }
}
