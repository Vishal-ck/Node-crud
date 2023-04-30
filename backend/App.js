const express = require("express");
const bodyParser = require("body-parser");
const cors = require("cors");
const app = new express();
app.use(bodyParser.json());
app.use(cors());
const expenses = [
  { id: 1, title: "fuel", price: 100 },
  { id: 2, title: "food", price: 250 },
];
const costly = [{ id: 1, title: "fuel", price: 60000, desc: "activa" }];
//GET
app.get("/expenses121", (req, res) => {
  res.send(expenses);
});

///ADD

app.post("/expenses12", (req, res) => {
  let newId = expenses[expenses.length - 1].id + 1;
  let newExpenses = req.body;
  newExpenses.id = newId;
  expenses.push(newExpenses);
  if (newExpenses.amount >= 5000) {
    costly.push(newExpenses);
  }
  res.send(expenses);
});

//RETRIVE

app.get("/expenses/:id", (req, res) => {
  const id = req.params.id;
  let result = 0;
  for (let i = 0; i < expenses.length; i++) {
    if (expenses[i].id == id) {
      result = expenses[i];
      break;
    }
  }
  // console.log(result);
  if (result) {
    res.send(result);
  } else {
    res.send("404 Not Found");
  }
});

//DELETE

app.delete("/expenses/:id", (req, res) => {
  let id = req.params.id;
  let state = 0;
  for (let index = 0; index < expenses.length; index++) {
    if (expenses[index].id == id) {
      expenses.splice(id - 1, 1);
      state = 1;
      break;
    }
  }

  if (state == 1) {
    res.send("deleted");
  } else {
    res.send("ERRRRR NOT FOUND");
  }
});

//PUT
app.put("/expenses/:id", (req, res) => {
  let id = req.params.id;
  let state = false;
  for (let index = 0; index < expenses.length; index++) {
    if (expenses[index].id == id) {
      state = true;
      if (req.body.title) {
        expenses[index].title = req.body.title;
      }
      if (req.body.amount) {
        expenses[index].amount = req.body.amount;
      }
      if (req.body.desc) {
        expenses[index].desc = req.body.desc;
      }
    }
  }
  if (state) {
    res.send("UPDATED");
  } else {
    res.Send("ID NOT FOUND");
  }
});

app.listen(3000, () => {
  console.log("YOO WHATSAPPPPPPPPPPPUUUUU");
});
