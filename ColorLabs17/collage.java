class collage
{
    public static void main(String[]args)
    {
        // Adding the pictures
        Picture avengers= new Picture("images/avengers.jpg");
        Picture mycanvas= new Picture("images/largecanvas.jpg");
        Picture ironman= new Picture("images/irnman.jpg");
        Picture collage= new Picture("images/collage.jpg");
        //Calling the methods for to edit an image
        //The edits of all the iages is not there becuase when they were all stacking up I got an out of memmory error and so I edited eac image then deletd the code and edited the next.
        ironman.maxGreen();
        //Calling the copy method to copy the dited image onto the collage
        collage.copy(ironman);
        //Saving the new version of the collage on to the images folder
        collage.write(FileChooser.getMediaPath("images"));
        collage.write("images/collage.jpg");
        collage.explore();
    }
}