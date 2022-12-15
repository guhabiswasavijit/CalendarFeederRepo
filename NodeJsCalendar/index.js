import express from 'express';
var app = express();
app.set('view engine', 'ejs');

app.get('/about', function(req, res) {
  res.render('pages/about');
});

app.listen(9090);
console.log('Server is listening on port 9090');