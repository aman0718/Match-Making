



const ProfileCard = ({profile}) =>{
    const { imageUrl, name, age, jobTitle, industry, location, bio } = profile;

    return (
         <div className="bg-white rounded-xl shadow-lg overflow-hidden w-full max-w-md mx-auto border-1 m-2">
            {/* Card Header */}
            <div className="h-[300px] w-full">
                <img
                    src={imageUrl}
                    alt='img'
                    className="w-full h-full object-cover"
                />
            </div>  

            {/* Card Body */}
            <div className="px-6 py-4 space-y-2 text-white" style={{backgroundColor: '#f2ad73'}}>
                <h2 className="text-2xl font-bold">{name}, <span className="text-lg font-medium text-white">{age}</span></h2>
                <p className="text-sm text-white">{jobTitle} | {industry}</p>
                <p className="text-sm text-white">{location}</p>
                <p className="mt-2 text-white-200">{bio}</p>
            </div>
        </div>
    )
}

export default ProfileCard;