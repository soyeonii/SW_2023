const mongoose = require("mongoose");
const Schema = mongoose.Schema;

const memberSchema = new Schema({
  id: String,
  password: String,
  name: String,
  manager: { type: Boolean, require: true },
});

module.exports = mongoose.model("Member", memberSchema);
