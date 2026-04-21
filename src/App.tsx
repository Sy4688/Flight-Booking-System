import { BrowserRouter, Routes, Route, Link } from "react-router-dom";
import Flights from "./pages/Flights";
import Passengers from "./pages/Passengers";

function App() {
  return (
    <BrowserRouter>
      <Link to="/">Flights</Link> |{" "}
      <Link to="/passengers">Passengers</Link>

      <Routes>
        <Route path="/" element={<Flights />} />
        <Route path="/passengers" element={<Passengers />} />
      </Routes>
    </BrowserRouter>
  );
}

export default App;