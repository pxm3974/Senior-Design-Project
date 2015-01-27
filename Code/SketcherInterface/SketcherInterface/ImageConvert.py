from PIL import Image
from PIL import ImageFilter
from PIL import ImageOps
from PIL import ImageDraw
 
def dodge(a, b, alpha):
    return min(int(a*255/(256-b*alpha)), 255)
def drawing(infile, outfile, blur=25, alpha=1.0):
    im1 = Image.open(infile).convert("L")
    im2 = im1.copy()
    im2 = ImageOps.invert(im2)
    for i in range(blur):
        im2 = im2.filter(ImageFilter.BLUR)
    width, height = im1.size
    for x in range(width):
        for y in range(height):
            a = im1.getpixel((x, y))
            b = im2.getpixel((x, y))
            im1.putpixel((x, y), dodge(a, b, alpha))
    im1.save(outfile)