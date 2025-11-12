// import React from "react";
// import {BrowserRouter as Router, Routes, Route, Link} from "react-router-dom";
// import MovieList from "./pages/MovieList";

// export default function App(){
//   return (
//     <Router>
//       <nav className="bg-gray-900 text-white p-4 flex justify-between">
//         <h1 className="text-2xl font-bold text-red-400">BookMyShow</h1>
//         <div>
//           <Link to="/" className="px-4 hover:text-red-400">Movies</Link>
//         </div>
//       </nav>

//       <div className="p-6">
//         <Routes>
//           <Route path="/" element={<MovieList />} />
//         </Routes>
//       </div>
//     </Router>
//   )
// }

export default function App() {
  return (
    <div className="flex justify-center items-center min-h-screen bg-gray-100">
      <h1 className="text-5xl font-bold text-blue-600">
        Tailwind v4 is working! 🚀
      </h1>
    </div>
  );
}