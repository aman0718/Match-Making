


const Filter = () =>{
    return (

         <section 
            className="bg-gray-100 text-gray-700 py-6 px-6 rounded-lg shadow-lg mt-22 m-2" 
           >
            {/* Tagline */}
            <div className="text-center mb-10">
                <h1 className="text-4xl md:text-5xl font-bold">Find your perfect connection</h1>
                <p className="mt-4 text-lg md:text-xl text-purple-600">Discover people that match your vibe</p>
            </div>

            {/* Filter Box */}
            <div className="bg-white rounded-lg shadow-md px-6 py-8 max-w-4xl mx-auto text-gray-800">
                <form className="grid grid-cols-1 md:grid-cols-3 gap-6">
                {/* Location Filter */}
                <div>
                    <label className="block mb-2 font-semibold">Location</label>
                    <select className="w-full border border-gray-300 rounded px-4 py-2">
                        <option value="">Anywhere</option>
                        <option value="delhi">Delhi</option>
                        <option value="mumbai">Mumbai</option>
                        <option value="bangalore">Bangalore</option>
                    </select>
                </div>

                {/* Age Range Filter */}
                <div className="flex flex-col">
                    <label className="block mb-2 font-semibold">Age Range</label>
                    <input
                        type="number"   
                        max={99}
                        placeholder="45"
                        className="w-full border border-gray-300 rounded px-4 py-2"
                    />
                
                   
                </div>

                {/* Match Intent Filter */}
                    <div>
                        <label className="block mb-2 font-semibold">Preference</label>
                        <select className="w-full border border-gray-300 rounded px-4 py-2">
                            <option value="">Any</option>
                            <option value="friendship">Friendship</option>
                            <option value="relationship">Relationship</option>
                            <option value="professional">Marriage</option>
                        </select>
                    </div>
                </form>
            </div>
        </section>

    )
}

export default Filter;