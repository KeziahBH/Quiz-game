let questions = [];
let index = 0;
let score = 0;
let selected = false;

const questionEl = document.getElementById("question-text");
const optionsEl = document.getElementById("options");
const nextBtn = document.getElementById("next-btn");

async function loadQuestions() {
    const res = await fetch("http://localhost:8080/questions");
    questions = await res.json();
    showQuestion();
}

function showQuestion() {
    selected = false;
    nextBtn.disabled = true;

    const q = questions[index];
    questionEl.innerText = q.question;

    optionsEl.innerHTML = "";
    q.options.forEach(opt => {
        let btn = document.createElement("button");
        btn.innerText = opt;
        btn.onclick = () => selectOption(btn, q.answer);
        optionsEl.appendChild(btn);
    });
}

function selectOption(button, correct) {
    if (selected) return;
    selected = true;

    const isCorrect = button.innerText === correct;

    if (isCorrect) {
        score++;
        button.classList.add("correct");
    } else {
        button.classList.add("wrong");
    }

    nextBtn.disabled = false;
}

nextBtn.onclick = () => {
    index++;
    if (index < questions.length) {
        showQuestion();
    } else {
        showScore();
    }
};

function showScore() {
    document.getElementById("quiz-box").classList.add("hidden");

    const resBox = document.getElementById("result-box");
    resBox.classList.remove("hidden");

    document.getElementById("final-score").innerText = `${score} / ${questions.length}`;
}

function restart() {
    index = 0;
    score = 0;
    document.getElementById("result-box").classList.add("hidden");
    document.getElementById("quiz-box").classList.remove("hidden");
    showQuestion();
}

loadQuestions();
