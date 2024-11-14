import type { Metadata } from "next";
import { Work_Sans } from 'next/font/google';
import "./globals.css";


export const metadata: Metadata = {
  title: "s19-06-webapp",
  description: "Música, Reproductor de música, artistas, canciones, álbumes",
};

const globalFont = Work_Sans({ subsets: ["latin"], weight: "400" });

interface RootLayoutProps {
  children: React.ReactNode;
}

export default function RootLayout({ children }: RootLayoutProps) {
  return (
    <html lang="en" suppressHydrationWarning>
      <body className={`${globalFont.className} bg-slate-400`}>

        <main className="container mx-auto ">
          {children}
        </main>
      </body>
    </html>
  );
}

